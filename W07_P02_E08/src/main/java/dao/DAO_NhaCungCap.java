package dao;

import dao_interface.I_DAO_NhaCungCap;
import jakarta.persistence.EntityManager;
import model.NhaCungCap;

import java.util.List;

public class DAO_NhaCungCap implements I_DAO_NhaCungCap {

    private final EntityManager entityManager;

    public DAO_NhaCungCap(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<NhaCungCap> getAll() {
        return entityManager.createQuery("SELECT ncc FROM NhaCungCap ncc", NhaCungCap.class).getResultList();
    }

    @Override
    public NhaCungCap getByID(int id) {
        return entityManager.find(NhaCungCap.class, id);
    }
}
