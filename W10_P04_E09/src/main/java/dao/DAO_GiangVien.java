package dao;

import dao_interface.I_DAO_GiangVien;
import model.GiangVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAO_GiangVien implements I_DAO_GiangVien {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GiangVien> getAllGiangVien() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from GiangVien", GiangVien.class).getResultList();
    }

    @Override
    public GiangVien getGiangVienById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(GiangVien.class, id);
    }

}
