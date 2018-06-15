package org.game.avengers.domain.model.creature;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttributeTest {

    @Test
    public void shouldReturnHumanMaleAttributes() {
        //given when
        Attribute attribute = Attribute.loadCharacterAttribute(Race.HUMAN, Gender.MALE);

        //then
        assertEquals(100, attribute.getHealth(), 0.0f);
        assertEquals(12, attribute.getDamageRatio(), 0.0f);
    }

    @Test
    public void shouldReturnHumanFemaleAttributes() {
        //given when
        Attribute attribute = Attribute.loadCharacterAttribute(Race.HUMAN, Gender.FEMALE);

        //then
        assertEquals(100, attribute.getHealth(), 0.0f);
        assertEquals(9, attribute.getDamageRatio(), 0.0f);
    }

    @Test
    public void shouldReturnAwokenMaleAttributes() {
        //given when
        Attribute attribute = Attribute.loadCharacterAttribute(Race.AWOKEN, Gender.MALE);

        //then
        assertEquals(100, attribute.getHealth(), 0.0f);
        assertEquals(3.0, attribute.getDamageRatio(), 0.33f);
    }

    @Test
    public void shouldReturnAwokenFemaleAttributes() {
        //given when
        Attribute attribute = Attribute.loadCharacterAttribute(Race.AWOKEN, Gender.FEMALE);

        //then
        assertEquals(100, attribute.getHealth(), 0.0f);
        assertEquals(8, attribute.getDamageRatio(), 0.0f);
    }

    @Test
    public void shouldReturnExoMaleAttributes() {
        //given when
        Attribute attribute = Attribute.loadCharacterAttribute(Race.EXO, Gender.MALE);

        //then
        assertEquals(100, attribute.getHealth(), 0.0f);
        assertEquals(10, attribute.getDamageRatio(), 0.0f);
    }

    @Test
    public void shouldReturnExoFemaleAttributes() {
        //given when
        Attribute attribute = Attribute.loadCharacterAttribute(Race.EXO, Gender.FEMALE);

        //then
        assertEquals(100, attribute.getHealth(), 0.0f);
        assertEquals(10, attribute.getDamageRatio(), 0.0f);
    }

}
