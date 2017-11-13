package com.mikaelkulma.kata.gameoflife

import spock.lang.Specification

class GameWorldSpec extends Specification {

    private gameWorld = new GameWorld()

    def "an empty word results in an empty generation 1"() {
        setup:
        gameWorld.evolve()

        expect:
        gameWorld.aliveCells == 0
    }

    def "a blinker results in generation 1 with 3 cells"() {
        setup:
        startWithThreeAdjacentCells()
        gameWorld.evolve()

        expect:
        gameWorld.aliveCells == 3
    }

    def "a blinker results in generation 100 with 3 cells"() {
        setup:
        startWithThreeAdjacentCells()
        100.times {
            gameWorld.evolve()
        }

        expect:
        gameWorld.aliveCells == 3
    }

    def "a cross shape results in generation 1 with 8 cells"() {
        setup:
        startWithACrossShape()
        gameWorld.evolve()

        expect:
        gameWorld.aliveCells == 8
    }

    def "a cross shape results in generation 8 with 12 cells"() {
        setup:
        startWithACrossShape()
        8.times {
            gameWorld.evolve()
        }

        expect:
        gameWorld.aliveCells == 12
    }

    def "a cross shape results in generation 1000 with 12 cells"() {
        setup:
        startWithACrossShape()
        1000.times {
            gameWorld.evolve()
        }

        expect:
        gameWorld.aliveCells == 12
    }

    def "a diehard results in generation 40 with 19 cells"() {
        setup:
        startWithADieHard()
        40.times {
            gameWorld.evolve()
        }

        expect:
        gameWorld.aliveCells == 19
    }

    def "a diehard results in generation 129 with 2 cells"() {
        setup:
        startWithADieHard()
        129.times {
            gameWorld.evolve()
        }

        expect:
        gameWorld.aliveCells == 2
    }

    def "a diehard results in generation 130 with 0 cells"() {
        setup:
        startWithADieHard()
        130.times {
            gameWorld.evolve()
        }

        expect:
        gameWorld.aliveCells == 0
    }

    def "an acorn results in generation 5206 with 633 cells"() {
        setup:
        startWithAnAcorn()
        5206.times {
            gameWorld.evolve()
        }

        expect:
        gameWorld.aliveCells == 633
    }

    void startWithThreeAdjacentCells() {
        addCellTo(1, 2);
        addCellTo(2, 2);
        addCellTo(3, 2);
    }

    void startWithACrossShape() {
        addCellTo(2, 1);
        addCellTo(1, 2);
        addCellTo(2, 2);
        addCellTo(3, 2);
        addCellTo(2, 3);
    }

    void startWithADieHard() {

        addCellTo(1, 2);
        addCellTo(2, 2);
        addCellTo(2, 3);
        addCellTo(7, 1);
        addCellTo(6, 3);
        addCellTo(7, 3);
        addCellTo(8, 3);
    }

    void startWithAnAcorn() {
        addCellTo(1, 3);
        addCellTo(2, 1);
        addCellTo(2, 3);
        addCellTo(4, 2);
        addCellTo(5, 3);
        addCellTo(6, 3);
        addCellTo(7, 3);
    }

    void addCellTo(x, y) {
        gameWorld.addCell(new Point(x: x, y: y), new AliveCell())
    }
}