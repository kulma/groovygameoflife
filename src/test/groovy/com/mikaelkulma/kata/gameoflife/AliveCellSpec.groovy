package com.mikaelkulma.kata.gameoflife

import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

class AliveCellSpec extends Specification {

    Cell cell = new AliveCell();

    @Unroll
    def "It evolves into a live cell with #count neighbours"() {

        expect:
        cell.evolve(count) instanceof AliveCell

        where:
        count << [2, 3]
    }

    @Unroll
    def "It evolves into a dead cell with #count neighbours"() {

        expect:
        cell.evolve(count) instanceof DeadCell

        where:
        count << [0, 1, 4, 5, 6, 7, 8]
    }

}
