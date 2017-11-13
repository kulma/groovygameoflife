package com.mikaelkulma.kata.gameoflife

interface Cell {

    Cell evolve(int numberOfLiveNeighbours)

    Boolean isAlive()
}