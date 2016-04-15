package pl.java.scalatech.collections;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.util.Set;

import org.junit.FixMethodOrder;

import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.AbstractConcreteClazzHibTest;
import pl.java.scalatech.domain.collection.AddressCollect;
import pl.java.scalatech.domain.collection.CustomerCollect;
@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class ElementCollectionTest extends AbstractConcreteClazzHibTest{

    @Override
    public Class<?>[] getEntities() {
        return new Class[]{CustomerCollect.class};
    }

    @Override
    //TODO convert to lamba expression
    public Object createEntity(int i) {
        Set<AddressCollect> acSet = Sets.newHashSet();
        for(int j =0;j<3;j++){
        AddressCollect ac = new AddressCollect("add"+j, "city_"+j, "state_"+j, "zip_"+j);
        acSet.add(ac);
        }
        CustomerCollect cc = new CustomerCollect("name_"+i,acSet);
        return cc;
    }





}
