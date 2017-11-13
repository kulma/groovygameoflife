package com.mikaelkulma.kata.gameoflife

class GameWorld {

    Map<Point, Cell> currentGeneration = new HashMap<>()

    void evolve() {
        Map<Point, Cell> nextGeneration = new HashMap<>()

        for(entry in currentGeneration) {

            Point point = entry.key
            Cell cell = entry.value

            Cell oldCell = EvolveCellAtPoint(point, cell)

            if (oldCell.isAlive()) {
                nextGeneration.put(point, oldCell)
            }

            for (neighBouringPoint in neighbouringPointsFor(point)) {
                Cell neighbourCell = currentGeneration.get(neighBouringPoint) ?: new DeadCell()

                if (!neighbourCell.isAlive() && !neighbourCell.evolved) {
                    Cell newCell = EvolveCellAtPoint(neighBouringPoint, neighbourCell)

                    if (newCell.isAlive()) {
                        nextGeneration.put(neighBouringPoint, newCell)
                    }
                }
            }
        }

        currentGeneration = nextGeneration
    }

    private EvolveCellAtPoint(Point point, Cell cell) {
        cell.evolve countingNeighboursAt(point)
    }

    private int countingNeighboursAt(Point point) {
        def count = 0;

        for (neighBouringPoint in neighbouringPointsFor(point)) {
            count = (currentGeneration.get(neighBouringPoint) ?: new DeadCell()) + count
        }

        count
    }

    private static List neighbouringPointsFor(Point point) {
        [
                new Point(x: point.x - 1, y: point.y - 1),
                new Point(x: point.x, y: point.y - 1),
                new Point(x: point.x + 1, y: point.y - 1),
                new Point(x: point.x - 1, y: point.y),
                new Point(x: point.x + 1, y: point.y),
                new Point(x: point.x - 1, y: point.y + 1),
                new Point(x: point.x, y: point.y + 1),
                new Point(x: point.x + 1, y: point.y + 1)
        ]
    }

    void addCell(Point point, Cell cell) {
        currentGeneration.put(point, cell)
    }

    int getAliveCells() {
        currentGeneration.size()
    }
}
