package dao_interface;

import java.util.List;

import model.DeTai;

public interface I_DAO_DeTai {

    List<DeTai> getAll();
    boolean add(DeTai deTai);

}
