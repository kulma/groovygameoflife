package com.mikaelkulma.kata.gameoflife

class DeadCell implements Cell {

    final int value = 0

    boolean evolved = false

    @Override
    Cell evolve(int numberOfLiveNeighbours) {
        evolved = true;
        [
                (false as Boolean): new DeadCell(),
                (true as Boolean) : new AliveCell()
        ].get(numberOfLiveNeighbours == 3)
    }

    @Override
    Boolean isAlive() {
        return false
    }

    def plus(int addend) {
        value + addend
    }
}
