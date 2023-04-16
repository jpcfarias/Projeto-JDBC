package pos.java.jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBanco {
    @Test
    public void initBanco(){
        UserPosDAO userPosDAO = new UserPosDAO();
        Userposjava userposjava = new Userposjava();

        userposjava.setNome("Joao");
        userposjava.setEmail("jao@gmail.com");

        userPosDAO.salvar(userposjava);
    }

    @Test
    public void initListar(){
        UserPosDAO dao = new UserPosDAO();
        try {
            List<Userposjava> list = dao.listar();

            for (Userposjava userposjava : list) {
                System.out.println(userposjava);
                System.out.println("-------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initBuscar(){
        UserPosDAO dao = new UserPosDAO();

        try {
            Userposjava userposjava = dao.buscar(1L);

            System.out.println(userposjava);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initAtualizar() {
        UserPosDAO dao = new UserPosDAO();
        try {
            Userposjava objetobanco = dao.buscar(3L);

            objetobanco.setId(1L);

            dao.atualiazar(objetobanco);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initDeletar(){

        UserPosDAO dao = new UserPosDAO();
        dao.deletar(6L);
    }

    @Test
    public void testeDeleteUserFone() {
        UserPosDAO dao = new UserPosDAO();

        dao.deletarFonesPorUser(3L);
    }

    @Test
    public void testeInsertTelefone() {

        Telefone telefone = new Telefone();
        telefone.setNumero("61 9 86412848");
        telefone.setTipo("Celular");
        telefone.setUsuario(4L);

        UserPosDAO dao = new UserPosDAO();
        dao.salvarTelefone(telefone);


    }

    @Test
    public void testeCarregaFonesUser() {
        
        UserPosDAO dao = new UserPosDAO();
        List<BeanUserFone> beanUserFones = dao.listaUserFone(4L);

        for (BeanUserFone beanUserFone : beanUserFones) {
            System.out.println(beanUserFone);
            System.out.println("-------------------------------------------");
        }
    }
}
