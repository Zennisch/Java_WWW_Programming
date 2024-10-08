package script;

import dao.DAO_DienThoai;
import dao_interface.I_DAO_DienThoai;
import jakarta.persistence.EntityManager;
import model.NhaCungCap;
import utility.HibernateUtility;

public class DienThoai {

    public static void main(String[] args) {

    }

    private static void addDienThoai() {
        HibernateUtility hibernateUtility = new HibernateUtility();
        EntityManager entityManager = hibernateUtility.getEntityManager();
        I_DAO_DienThoai dao_dienThoai = new DAO_DienThoai(entityManager);


//        public DienThoai(int maDienThoai, String tenDienThoai, int namSanXuat, String cauHinh, NhaCungCap nhaCungCap)
        DienThoai dienThoai01 = new DienThoai("Samsung Galaxy S21", 2021, "Snapdragon 888, 8GB RAM, 128GB ROM", new NhaCungCap(1));
    }

}
