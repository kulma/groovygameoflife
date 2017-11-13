package com.mikaelkulma.kata.gameoflife

import spock.lang.Specification
import spock.lang.Unroll

class DeadCellSpec extends Specification {

    Cell cell = new DeadCell();

    def "it evolves into a live cell with 3 neighbours"() {

        expect:
        cell.evolve(3) instanceof AliveCell
    }

    @Unroll
    def "it evolves into a dead cell with #count neighbours"() {

        expect:
        cell.evolve(count) instanceof DeadCell

        where:
        count << [0, 1, 2, 4, 5, 6, 7, 8]
    }
}