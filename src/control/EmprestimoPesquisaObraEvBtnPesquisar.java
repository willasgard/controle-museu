package control;

import infrastructure.ObraDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import boundary.EmprestimoPesquisaObraBoundary;
import entity.ObraEntity;

public class EmprestimoPesquisaObraEvBtnPesquisar implements ActionListener{

	private JTextField TxtPesquisar;
	private JTable tabela;
	
	
	
	public EmprestimoPesquisaObraEvBtnPesquisar(JTextField txtPesquisar, JTable tabela) {
		super();
		this.TxtPesquisar = txtPesquisar;
		this.tabela = tabela;
	}


	public void preenchertabela(){
		ObraDAO dao = new ObraDAO();
		List<ObraEntity> listaResultado = dao.selectByObrasDisponiveis(TxtPesquisar.getText());
		DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
		
		
		//limpando todos os registros da tabela 
		while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }															

		// adicionando as linha do array list para o defaulttablemodel
		for (ObraEntity obra: listaResultado){
			modeloTabela.addRow(new Object[]{obra.getId(),obra.getNomeObra(),obra.getNomeAutor(),obra.getLocalizacaoObra()});
			
		}
		
		tabela.setModel(modeloTabela);
		
		
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		preenchertabela();
	}

}
