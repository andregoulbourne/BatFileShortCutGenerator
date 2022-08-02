package com.utility.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.utility.PojoTest;
import com.utility.models.ShortCutBATVO;

class ShortCutBATVOTest extends PojoTest {

    @Test
    void testPojo(){
        pojoValidator.validate(PojoClassFactory.getPojoClass(ShortCutBATVO.class));
    }

    @Test
    void testEquals_returnsValid(){
        ShortCutBATVO shortCutBATVO = new ShortCutBATVO();
        ShortCutBATVO shortCutBATV01 = new ShortCutBATVO();
        ShortCutBATVO shortCutBATV03 = new ShortCutBATVO();
        shortCutBATV03.setShortCutName("something");

        assertTrue(shortCutBATVO.equals(shortCutBATVO));
        assertTrue(shortCutBATVO.equals(shortCutBATV01));
        assertFalse(shortCutBATVO.equals(shortCutBATV03));
        assertFalse(shortCutBATVO.equals(null));
    }

    @Test
    void testHashCode_returnsValid(){
        ShortCutBATVO shortCutBATVO = new ShortCutBATVO();

        assertNotNull(shortCutBATVO.hashCode());
    }

}
