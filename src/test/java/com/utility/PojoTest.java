package com.utility;

import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.EqualsAndHashCodeMatchRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PojoTest {

    protected Validator pojoValidator;

    @BeforeEach
    public void setup() throws Exception {
        pojoValidator = ValidatorBuilder.create()
                .with(new GetterTester())
                .with(new SetterTester())
                .with(new EqualsAndHashCodeMatchRule())
                .build();
    }

    @Test
    public void test_this(){
        assertNotNull(pojoValidator);
    }

}
