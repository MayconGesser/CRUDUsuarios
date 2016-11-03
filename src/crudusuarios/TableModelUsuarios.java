/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudusuarios;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import entidade.Usuario;

/**
 *
 * @author maycon
 */
public class TableModelUsuarios extends AbstractTableModel{ 

    private Map<Integer, Usuario> usuarios;
    private ArrayList<String> colunas;

    public TableModelUsuarios(Map<Integer,Usuario> usuarios){
        this.usuarios = usuarios;
        this.colunas = new ArrayList<String>() {
            {
                add("Codigo");
                add("Nome");
                add("Email");
                add("Telefone");
            }
        };
    }

    @Override
    public int getRowCount() {
        if (this.usuarios == null)
            return 0;
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public String getColumnName(int i) {
        return colunas.get(i);
    }

    @Override
    public Object getValueAt(int r, int c) {
        if (this.usuarios != null) {
            Usuario usuario = usuarios.get(r);

            switch (c) {
                case 0:
                    return usuario.getCodUsuario();
                case 1:
                    return usuario.getNome();
                case 2:
                    return usuario.getEmail();
                case 3:
                    return usuario.getTelefone();
            }
        }
        return null;
    }
}
