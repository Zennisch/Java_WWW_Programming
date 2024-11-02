package dao;

import dao_interface.I_DAO_DeTai;
import model.DeTai;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAO_DeTai implements I_DAO_DeTai {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<DeTai> getAllDeTai() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from DeTai dt JOIN FETCH dt.giangVien", DeTai.class).getResultList();
    }

    @Override
    public DeTai getDeTaiById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(DeTai.class, id);
    }

    @Override
    public boolean createDeTai(DeTai deTai) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(deTai);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    @Override
    public boolean updateDeTai(DeTai deTai) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(deTai);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    @Override
    public boolean deleteDeTai(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            DeTai deTai = session.get(DeTai.class, id);
            session.remove(deTai);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }
}
