package Utils;

import Entities.*;
import EntityGroups.TariffGroup;

import java.sql.SQLException;
import java.util.List;

public class TestEntities {
    public static void main(String[] args) throws SQLException {

        /*UserEntity user = Service.findById(UserEntity.class, 4);
        PropertyEntity p =  Service.findById(PropertyEntity.class, 2);

       DocumentEntity t = Service.findById(DocumentEntity.class,1) ;

       ContractEntity contract = new ContractEntity("first0145");
        contract.setDocumentByDocumentId(t);
        contract.setUserByHolderId(user);
        contract.setPropertyByPropertyId(p);

        contract.save();

        ContractEntity tc = new ServiceGroup(ContractEntity.class).findById(1) ;
        System.out.println(tc.calcTitle());
        try {
            tc.calcEnsurance();
            tc.update();
        }catch (TariffException e){
            e.fillInStackTrace();
        }*/
        TariffGroup tg = new TariffGroup();
        tg.read();
        System.out.println();
        for (TariffEntity tt : (List<TariffEntity>)tg.models()){
            System.out.println();
            System.out.print(tt.calcTitle()+" | ");
            for (Meta.Column col : tt.getSelectorColumns()){
                System.out.print(col.getName() +"="+col.getValue() +" | ");
            }
       }


    }
}
