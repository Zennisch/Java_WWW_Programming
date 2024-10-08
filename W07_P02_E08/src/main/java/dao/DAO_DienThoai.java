package dao;

import dao_interface.I_DAO_DienThoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.DienThoai;

import java.util.List;

public class DAO_DienThoai implements I_DAO_DienThoai {

    private final EntityManager entityManager;

    public DAO_DienThoai(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<DienThoai> getAll() {
        return entityManager.createQuery("SELECT dt FROM DienThoai dt", DienThoai.class).getResultList();
    }

    @Override
    public DienThoai getByID(int id) {
        return entityManager.find(DienThoai.class, id);
    }

    @Override
    public boolean add(DienThoai dienThoai) {
        EntityTransaction entityTransaction;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(dienThoai);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    @Override
    public boolean update(DienThoai dienThoai) {
        EntityTransaction entityTransaction;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(dienThoai);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        EntityTransaction entityTransaction;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            DienThoai dienThoai = entityManager.find(DienThoai.class, id);
            entityManager.remove(dienThoai);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }
}
