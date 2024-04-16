package escola;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class ÃlundoDAO {
    public static void inserirAluno(Aluno al) {
        ConexaoBD conn = new ConexaoBD();

        Connection c = conn.abrirBD();

        String sql = "INSERT INTO ALUNOS(nome, email, dataNascimento) Values("
                + "'" + al.getNome() + "',"
                + "'" + al.getEmail() + "',"
                + "'" + al.getIdade() + "',"
                + "'" + new Date(al.getDataNascimento() + getTime()) + "');";

        Statement stmt = null;

        try {
            //Instanciação do objeto Statement
            stmt = c.createStatement();

            //Executa a instrução SQL
            stmt.executeUpdate(sql); //Funciona para o INSERT, UPDATE, DELETE
            System.out.println("Aluno inserido na base de dados com sucesso...");
        } catch (SQLException ex){
            System.out.println("Erro ao inserir o aluno: "+ex);
        }
        finally {
            conn.fecharBD(stmt);
        }
    }

}
