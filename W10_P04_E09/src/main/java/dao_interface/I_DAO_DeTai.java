package dao_interface;

import model.DeTai;

import java.util.List;

public interface I_DAO_DeTai {

    List<DeTai> getAllDeTai();
    DeTai getDeTaiById(int id);
    boolean createDeTai(DeTai deTai);
    boolean updateDeTai(DeTai deTai);
    boolean deleteDeTai(int id);

}
