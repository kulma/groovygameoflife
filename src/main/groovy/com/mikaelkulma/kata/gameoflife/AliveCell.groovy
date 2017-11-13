package com.mikaelkulma.kata.gameoflife

class AliveCell implements Cell {

    final int value = 1

    boolean evolved = false

    @Override
    Cell evolve(int numberOfLiveNeighbours) {
        evolved = true;
        [
                (false as Boolean): new DeadCell(),
                (true as Boolean) : new AliveCell()
        ].get(numberOfLiveNeighbours == 2 || numberOfLiveNeighbours == 3)
    }

    @Override
    Boolean isAlive() {
        return true
    }

    def plus(int addend) {
        value + addend
    }
}
