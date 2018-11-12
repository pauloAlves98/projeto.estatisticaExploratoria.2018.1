package controller;
import java.awt.Color;
//falta estratificaada, gerar estograma.testes testar limites da base.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Base;
import model.DadosTabelaFrequencia;
import model.MedidasDeDispersao;
import model.TiradorDeAmostras;
import view.TelaGraficos;
import view.TelaTabelas;
//mudar cor do Header da tabela.
public class ControllerTabela implements ActionListener, MouseListener{
	TelaTabelas telaTabelas;
	public ControllerTabela(TelaTabelas tela){
		this.telaTabelas = tela;
		telaTabelas.getGerarTabelaButton().addActionListener(this);
		telaTabelas.item1.addActionListener(this);
		telaTabelas.exportarItem.addActionListener(this);
		telaTabelas.getEscolhaPesquisaBox().removeAllItems();
		telaTabelas.tabela.addMouseListener(this);
		telaTabelas.telaMedidas.calcularPercentilButton.addActionListener((ActionEvent e)->calculoPercentil());
		telaTabelas.telaMedidas.calcularPercentilNormalButton.addActionListener((ActionEvent e)->calculoPercentilNormal());
		for(int i = 0;i<Base.base.size();i++){//atualiza Pesquisas
			telaTabelas.getEscolhaPesquisaBox().addItem(Base.base.get(i).getNomePesquisa());
		}
		this.telaTabelas.getTipoAmostrasBox().addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(telaTabelas.getTipoAmostrasBox().getSelectedIndex()==3){
					if(telaTabelas.escolhaPesquisaBox.getModel().getSize()<=0){
						JOptionPane.showMessageDialog(null,"CRIE UMA PESQUISA PRIMEIRO!!!");
						return ;
					}
					telaTabelas.quantField.setText(""+Base.base.get(telaTabelas.escolhaPesquisaBox.getSelectedIndex()).getDadosPesquisa().size());
					telaTabelas.quantField.setEditable(false);
				}
				else
					telaTabelas.quantField.setEditable(true);
			}

		});
		telaTabelas.getEscolhaPesquisaBox().addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				//Base.base.get(telaGrafico.escolhaPesquisaBox.getSelectedIndex()).tipo.equalsIgnoreCase("Qualitativa");
				if(telaTabelas.getEscolhaPesquisaBox().getModel().getSize()<=0){
					return ;
				}
				if(Base.base.get(telaTabelas.getEscolhaPesquisaBox().getSelectedIndex()).isQualitativa()){
					telaTabelas.colunaIndicadora.setText("COLUNA INDICADORA");
					telaTabelas.colunaNumerica.setVisible(true);
					telaTabelas.colunaNumericaField.setVisible(true);
					telaTabelas.quantidadeAmostrasLabel.setVisible(true);
					telaTabelas.quantField.setVisible(true);
					telaTabelas.quantField.setText("1");
					telaTabelas.tipoAmostraLabel.setVisible(true);

					telaTabelas.getTipoAmostrasBox().setVisible(true);
					telaTabelas.getGerarTabelaButton().setText("GERAR TABELA");

				}else{
					telaTabelas.colunaIndicadora.setText("CLASSE");
					telaTabelas.quantField.setText("1");
					telaTabelas.colunaNumerica.setVisible(false);
					telaTabelas.colunaNumericaField.setVisible(false);
					telaTabelas.quantidadeAmostrasLabel.setVisible(false);
					telaTabelas.quantField.setVisible(false);
					telaTabelas.tipoAmostraLabel.setVisible(false);
					telaTabelas.getTipoAmostrasBox().setVisible(false);
					telaTabelas.getGerarTabelaButton().setText("GERAR TABELA");
				}
			}
		});

	}
	public static  boolean toExcel(JTable table,JFileChooser fileC,String nomeFile){
		try{
			File file = buscarDiretorio(fileC,nomeFile);
			if(file == null){
				//JOptionPane.showMessageDialog(null,"Nenhuma pasta selecionada");
				return false;
			}
			TableModel model = table.getModel();
			FileWriter excel = new FileWriter(file);
			for(int i = 0; i < model.getColumnCount(); i++){
				excel.write((model.getColumnName(i) + "\t"));
				
			}
			excel.write("\n");
			for(int i=0; i< model.getRowCount(); i++) {
				for(int j=0; j < model.getColumnCount(); j++) {
//					if(model.getValueAt(i,j).equals)
//						excel.write("0\t");
//					else
						excel.write((model.getValueAt(i,j).toString()+"\t"));
				}
				excel.write("\n");
			}
			excel.close();
		}catch(IOException e){ 
			return false; 
		}
		return true;
	}
	private static File buscarDiretorio(JFileChooser fileC,String nome){
		fileC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int i = fileC.showOpenDialog(null);
		String c = null;
		if(i ==  fileC.APPROVE_OPTION){
			c = fileC.getSelectedFile().getAbsolutePath();
			c = c+"/"+nome+".xls";

			File file = new File(c);
			try {
				if(!file.exists())
					file.createNewFile();
				else{
					file.delete();
					file.createNewFile();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return file;
		}
		return null;
	}
	public void actionPerformed(ActionEvent e) {
		int indicieP = telaTabelas.getEscolhaPesquisaBox().getSelectedIndex();
		if( e.getSource() == telaTabelas.item1){//se o item 1 o disparou
	
			TelaTabelas.telaMedidas.setVisible(true);
			//JOptionPane.showMessageDialog(null,"MIN:"+DadosTabelaFrequencia.mini +" MAX:"+DadosTabelaFrequencia.max);
			return;
		}else
			if( e.getSource() == telaTabelas.exportarItem){//se o exportar item disparou
				String nome = telaTabelas.tituloTabelaField.getText().replace(" ", "").length()<=0?new Date().toString().replace(":",""):telaTabelas.tituloTabelaField.getText().replace(" ", "");
				if(Base.base.get(indicieP).isQualitativa()) {
					if(toExcel(telaTabelas.tabela, telaTabelas.seletorFiles,nome))
						JOptionPane.showMessageDialog(null, "Arquivo Salvo!!!");
					else
						JOptionPane.showMessageDialog(null, "Não foi possivel salvar o arquivo!!!");
				}
				else {
					if(toExcel(tabelaFreqExport(), telaTabelas.seletorFiles,nome))
						JOptionPane.showMessageDialog(null, "Arquivo Salvo!!!");
					else
						JOptionPane.showMessageDialog(null, "Não foi possivel salvar o arquivo!!!!");
				}
				return;
			}
		//se o botão gerar o disparou
		int quantidadeAmostras = 0;
		try{
			quantidadeAmostras = Integer.parseInt(telaTabelas.getQuantField().getText().replace(" ",""));
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null,"Quantidade inválida!!!");
			return;
		}
	

		if(Base.base.size()>0){//significa que se tem uma pesquisa
			if(ControllerGraficos.validaTamanho(quantidadeAmostras,Base.base.get(indicieP).getDadosPesquisa().size())){
				JOptionPane.showMessageDialog(null,"A população não possui a quantidade de amostras necessárias ");
				return;
			}
			if(Base.base.get(indicieP).isQualitativa()){//então será esta Tabela
				ArrayList<String> nomesAnteriores = new ArrayList<String>();
				ArrayList<Integer> quantidade = new ArrayList<Integer>();
				if(telaTabelas.getTipoAmostrasBox().getSelectedIndex() == 0){//aleatoria
					TiradorDeAmostras.retiraAleatoria(quantidadeAmostras, nomesAnteriores, quantidade,Base.base.get(indicieP).getDadosPesquisa());
					String colunas[] = {telaTabelas.colunaIndicadoraField.getText(),telaTabelas.colunaNumericaField.getText()};
					String l[][] = new String[nomesAnteriores.size()][colunas.length];
					//falta ordernar
					for(int i = 0;i<nomesAnteriores.size();i++){
						l[i][0] = nomesAnteriores.get(i);
						l[i][1] = quantidade.get(i)	+"";
					}
					ordenarMatriz(l);
					atualizarTabelas(l,colunas);
					//System.out.println("Linhas"+telaTabelas.tabela.getModel().getRowCount()+"Colunas"+telaTabelas.tabela.getModel().getColumnCount());
				}
				if(telaTabelas.getTipoAmostrasBox().getSelectedIndex() == 1){//sistematica
					TiradorDeAmostras.retiraSistematica(quantidadeAmostras, nomesAnteriores, quantidade,Base.base.get(indicieP).getDadosPesquisa());
					String colunas[] =  {telaTabelas.colunaIndicadoraField.getText(),telaTabelas.colunaNumericaField.getText()};
					String l[][] = new String[nomesAnteriores.size()][colunas.length];
					//falta ordernar
					for(int i = 0;i<nomesAnteriores.size();i++){
						l[i][0] = nomesAnteriores.get(i);
						l[i][1] = quantidade.get(i)	+"";
					}
					ordenarMatriz(l);
					atualizarTabelas(l,colunas);
					System.gc();

				}
				if(telaTabelas.getTipoAmostrasBox().getSelectedIndex() == 2){//Estratificada
					TiradorDeAmostras.retiraEstratificada(quantidadeAmostras, nomesAnteriores, quantidade,Base.base.get(indicieP).getDadosPesquisa());
					String colunas[] =  {telaTabelas.colunaIndicadoraField.getText(),telaTabelas.colunaNumericaField.getText()};
					String l[][] = new String[nomesAnteriores.size()][colunas.length];
					//falta ordernar
					for(int i = 0;i<nomesAnteriores.size();i++){
						l[i][0] = nomesAnteriores.get(i);
						l[i][1] = quantidade.get(i)	+"";
					}
					ordenarMatriz(l);
					atualizarTabelas(l,colunas);
					System.gc();
				}
				if(telaTabelas.getTipoAmostrasBox().getSelectedIndex() == 3){//população
					TiradorDeAmostras.retiraAleatoria(Base.base.get(indicieP).getDadosPesquisa().size(), nomesAnteriores, quantidade,Base.base.get(indicieP).getDadosPesquisa());
					String colunas[] = {telaTabelas.colunaIndicadoraField.getText(),telaTabelas.colunaNumericaField.getText()};
					String l[][] = new String[nomesAnteriores.size()][colunas.length];
					//falta ordernar
					for(int i = 0;i<nomesAnteriores.size();i++){
						l[i][0] = nomesAnteriores.get(i);
						l[i][1] = quantidade.get(i)	+"";
					}
					ordenarMatriz(l);
					atualizarTabelas(l,colunas);
				}

			}else{//ai já eh a tabela Frequencia
				String [] dados = Base.base.get(indicieP).getDadosPesquisa().toArray(new String[Base.base.get(indicieP).getDadosPesquisa().size()]);
				DadosTabelaFrequencia.frequencia(dados);
				DadosTabelaFrequencia.frequenciaRelativa(Base.base.get(indicieP).getDadosPesquisa().size());
				DadosTabelaFrequencia.frequenciaAcumulada();
				DadosTabelaFrequencia.FrequenciaRelativa();
				DadosTabelaFrequencia.Xi(dados);
				DadosTabelaFrequencia.XiFi();
				String colunas[] =  {"<html><table><tr><td height=50>I</td></tr></table></html>"
						,telaTabelas.colunaIndicadoraField.getText(),"f","fr","F","FR","Xi","Xi*fi"};
				String l[][] = new String[DadosTabelaFrequencia.frequencia.length][colunas.length + 1];
				DecimalFormat df = new DecimalFormat("0.0000");
				df.setRoundingMode(RoundingMode.HALF_UP);


				for(int i = 0;i<DadosTabelaFrequencia.frequencia.length;i++){
					l[i][0] = i+1+"";
					l[i][1] = DadosTabelaFrequencia.classe[i];
					l[i][2] =  DadosTabelaFrequencia.frequencia[i]+"";
					l[i][3] =  df.format(DadosTabelaFrequencia.fr[i]);
					l[i][4] = DadosTabelaFrequencia.frequenciaAcumulada[i]+"";
					l[i][5] = df.format(DadosTabelaFrequencia.FR[i]);
					l[i][6] = df.format(DadosTabelaFrequencia.Xi[i]);
					l[i][7] = df.format(DadosTabelaFrequencia.XiFi[i]);
				}
				
				atualizarTabelas(l,colunas);
				DecimalFormat df5= new DecimalFormat("0.000000");
				df5.setRoundingMode(RoundingMode.HALF_UP);
				TelaTabelas.telaMedidas.percentilField.setText("");
				TelaTabelas.telaMedidas.mediaField.setText(""+df.format(MedidasDeDispersao.mediaNaTabela(Base.base.get(indicieP).getDadosPesquisa().size())));
				TelaTabelas.telaMedidas.modaField.setText(""+df.format(MedidasDeDispersao.modaNaTabela()));
				TelaTabelas.telaMedidas.medianaField.setText(""+df.format(MedidasDeDispersao.medianaNaTabela(Base.base.get(indicieP).getDadosPesquisa().size())));
				TelaTabelas.telaMedidas.amplitudeField.setText(""+df.format(MedidasDeDispersao.amplitude(dados)));
				TelaTabelas.telaMedidas.varianciaField.setText(""+df5.format(MedidasDeDispersao.varianciaNaTabela(Base.base.get(indicieP).getDadosPesquisa().size())));
				TelaTabelas.telaMedidas.desvioPadraoField.setText(""+df5.format(MedidasDeDispersao.desvioNaTabela(Base.base.get(indicieP).getDadosPesquisa().size())));
				TelaTabelas.telaMedidas.cofField.setText(""+df.format(MedidasDeDispersao.coeficienteDeVariacaoNaTabela(Base.base.get(indicieP).getDadosPesquisa().size())));
				TelaTabelas.telaMedidas.q1Field.setText(df.format(MedidasDeDispersao.quartilNaTabela(Base.base.get(indicieP).getDadosPesquisa().size(),1)));
				TelaTabelas.telaMedidas.q2Field.setText(TelaTabelas.telaMedidas.medianaField.getText());
				TelaTabelas.telaMedidas.q3Field.setText(df.format(MedidasDeDispersao.quartilNaTabela(Base.base.get(indicieP).getDadosPesquisa().size(),3)));
				
//COPY
				TelaTabelas.telaMedidas.reusultadoPercentilNormalField.setText("");
				TelaTabelas.telaMedidas.modaNormalField.setText(MedidasDeDispersao.modaNormal(dados).toString().replaceAll(","," - "));
				TelaTabelas.telaMedidas.mediaNormalField.setText(df.format(MedidasDeDispersao.mediaNormal(dados)));
				TelaTabelas.telaMedidas.medianaNormalField.setText(df.format(MedidasDeDispersao.medianaNormal(dados)));
				TelaTabelas.telaMedidas.varianciaNormalField.setText(df5.format(MedidasDeDispersao.varianciaAmostral(dados)));
				TelaTabelas.telaMedidas.desvioNormalField.setText(df5.format(MedidasDeDispersao.desvioPadraoAmostral(dados)));
				TelaTabelas.telaMedidas.coefNormalfield.setText(df.format(MedidasDeDispersao.coeficienteDeVariacaoAmostral(dados)));
				TelaTabelas.telaMedidas.maxNormalField.setText(df.format(DadosTabelaFrequencia.max));
				TelaTabelas.telaMedidas.minNormalField.setText(df.format(DadosTabelaFrequencia.mini));
				TelaTabelas.telaMedidas.quartil1NormalField.setText(df.format(MedidasDeDispersao.quartil(dados,1)));
				TelaTabelas.telaMedidas.quartil2NormalField.setText(df.format(MedidasDeDispersao.medianaNormal(dados)));
				TelaTabelas.telaMedidas.quartil3NormalField.setText(df.format(MedidasDeDispersao.quartil(dados,3)));
				//TelaTabelas.telaMedidas.mediaField.setText(""+df.format(MedidasDeDispersao.mediaNormal(Base.base.get(indicieP).dadosPesquisa.toArray(new String[Base.base.get(indicieP).dadosPesquisa.size()]))));
				//				TelaTabelas.telaMedidas.modaField.setText(""+df.format(MedidasDeDispersao.modaNormal(Base.base.get(indicieP).dadosPesquisa.toArray(new String[Base.base.get(indicieP).dadosPesquisa.size()]))));
				//				

				System.gc();
			}
		}else{
			JOptionPane.showMessageDialog(null,"Crie uma pesquisa primeiro!!!");
			return;
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//telaTabelas.tabela
		int indicieP = telaTabelas.getEscolhaPesquisaBox().getSelectedIndex();
		if(e.getButton() == e.BUTTON3  && e.getSource() == telaTabelas.tabela && Base.base.get(indicieP).isQualitativa() == false){
			telaTabelas.item1.setVisible(true);
			telaTabelas.menu.show(telaTabelas.painelTabela,e.getX()-150,e.getY()+10);
			System.out.println("AAA");
		}else
			if(e.getButton() == e.BUTTON3  && e.getSource() == telaTabelas.tabela && Base.base.get(indicieP).isQualitativa() == true){
				telaTabelas.item1.setVisible(false);
				telaTabelas.menu.show(telaTabelas.painelTabela,e.getX()-150,e.getY());
			}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	private void atualizarTabelas(String[][]l,String colunas[]){
		telaTabelas.setBackground(Color.WHITE);

		telaTabelas.getPainelTabela().tituloLabel.setText(telaTabelas.tituloTabelaField.getText());
		telaTabelas.getPainelTabela().fontLabel.setText(telaTabelas.fontField.getText());
		telaTabelas.tabela.setModel(new DefaultTableModel(l,colunas));
		//telaTabelas.painelTabela.panel.add(BorderLayout.SOUTH,telaTabelas.tabela);
		//telaTabelas.tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		telaTabelas.tabela.setShowGrid(false);
		telaTabelas.getPainelTabela().scrollPane.setViewportView(telaTabelas.tabela);
		telaTabelas.tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
		telaTabelas.tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
		telaTabelas.tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		//telaTabelas.getPainelTabela().scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		telaTabelas.tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		telaTabelas.tabela.setRowHeight(30);
		telaTabelas.tabela.setFont(TelaGraficos.font);

		//telaTabelas.tabela.setFont(new Font("Arial",Font.BOLD,11));
		telaTabelas.updateUI();
		System.gc();
	}
	public void calculoPercentil(){
		float num = 0;
		try{
			num = Float.parseFloat(telaTabelas.telaMedidas.numPerField.getText());
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null,"Digite Apenas Números!!!");
			return;
		}
		if(num>0){
			telaTabelas.telaMedidas.percentilField.setText(""+MedidasDeDispersao.percentilTabela(num,Base.base.get(telaTabelas.getEscolhaPesquisaBox().getSelectedIndex()).getDadosPesquisa().size()));
			System.out.println("Percentillll Tabela");
		}else
			JOptionPane.showMessageDialog(null,"Digite uma Posição valida!!!");
	}
	public void calculoPercentilNormal(){
		float num = 0;
		try{
			num = Float.parseFloat(telaTabelas.telaMedidas.numPercentilNormalField.getText());
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null,"Digite Apenas Números!!!");
			return;
		}
		if(num>0 && num <=100){
			int indicieP = telaTabelas.getEscolhaPesquisaBox().getSelectedIndex();
			String [] dados = Base.base.get(indicieP).getDadosPesquisa().toArray(new String[Base.base.get(indicieP).getDadosPesquisa().size()]);
			telaTabelas.telaMedidas.reusultadoPercentilNormalField.setText(""+MedidasDeDispersao.percentil(dados,(int)num));
			System.out.println("Percentillll normal");
		}else
			JOptionPane.showMessageDialog(null,"Digite uma Posição valida!!!");
	}
	private void ordenarMatriz(String[][]l){
		l = ((String[][])(l));
		for(int i = 0;i<l.length;i++){//ordenar do > para o <
			for(int j=i+1;j<l.length;j++){
				if(l[i][1].compareToIgnoreCase(l[j][1])<1){
					String auxNumero = l[i][1];
					String auxNome =  l[i][0];
					l[i][1] = l[j][1];
					l[i][0] = l[j][0];
					l[j][1] = auxNumero;
					l[j][0] = auxNome;
				}
			}
		}
	}
	private JTable tabelaFreqExport(){
		String colunas[] =  {"I",telaTabelas.colunaIndicadoraField.getText(),"f","fr","F","FR","Xi","Xi*fi"};
		String l[][] = new String[DadosTabelaFrequencia.frequencia.length][colunas.length + 1];
		DecimalFormat df = new DecimalFormat("0.00000");
		df.setRoundingMode(RoundingMode.HALF_UP);
		for(int i = 0;i<DadosTabelaFrequencia.frequencia.length;i++){
			l[i][0] = i+1+"";
			l[i][1] = DadosTabelaFrequencia.classe[i];
			l[i][2] =  DadosTabelaFrequencia.frequencia[i]+"";
			l[i][3] =  df.format(DadosTabelaFrequencia.fr[i]);
			l[i][4] = DadosTabelaFrequencia.frequenciaAcumulada[i]+"";
			l[i][5] = df.format(DadosTabelaFrequencia.FR[i]);
			l[i][6] = df.format(DadosTabelaFrequencia.Xi[i]);
			l[i][7] = df.format(DadosTabelaFrequencia.XiFi[i]);
		}
		return new JTable(l,colunas);
	}
}
