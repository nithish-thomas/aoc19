package astroids;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonitoringStationTest {

    @Test
    public void shouldDestoryAstroidAt1_9First() {
        final MonitoringStation monitoringStation = MonitoringStation.create(".#....#####...#..\n" +
          "##...##.#####..##\n" +
          "##...#...#.#####.\n" +
          "..#.....X...###..\n" +
          "..#.#.....#....##");

        final Asteroid asteroid = monitoringStation.asteroidToBeDestroyedAt(1);
        assertEquals(new Asteroid(8,1), asteroid);
    }

    @Test
    public void shouldDestoryAstroidsForLargeMapWithMonitoringStationAt11_13() {
        final MonitoringStation monitoringStation = MonitoringStation.create(".#..##.###...#######\n" +
          "##.############..##.\n" +
          ".#.######.########.#\n" +
          ".###.#######.####.#.\n" +
          "#####.##.#.##.###.##\n" +
          "..#####..#.#########\n" +
          "####################\n" +
          "#.####....###.#.#.##\n" +
          "##.#################\n" +
          "#####.##.###..####..\n" +
          "..######..##.#######\n" +
          "####.##.####...##..#\n" +
          ".#####..#.######.###\n" +
          "##...#.####X#####...\n" +
          "#.##########.#######\n" +
          ".####.#.###.###.#.##\n" +
          "....##.##.###..#####\n" +
          ".#.#.###########.###\n" +
          "#.#.#.#####.####.###\n" +
          "###.##.####.##.#..##");

        assertEquals(new Asteroid(11,12), monitoringStation.asteroidToBeDestroyedAt(1));
        assertEquals(new Asteroid(12,1), monitoringStation.asteroidToBeDestroyedAt(2));
        assertEquals(new Asteroid(12,8), monitoringStation.asteroidToBeDestroyedAt(10));
        assertEquals(new Asteroid(8,2), monitoringStation.asteroidToBeDestroyedAt(200));
    }



    @Test
    public void printDay10_2() {
        final MonitoringStation monitoringStation = MonitoringStation.create("#.#.###.#.#....#..##.#....\n" +
          ".....#..#..#..#.#..#.....#\n" +
          ".##.##.##.##.##..#...#...#\n" +
          "#.#...#.#####...###.#.#.#.\n" +
          ".#####.###.#.#.####.#####.\n" +
          "#.#.#.##.#.##...####.#.##.\n" +
          "##....###..#.#..#..#..###.\n" +
          "..##....#.#...##.#.#...###\n" +
          "#.....#.#######..##.##.#..\n" +
          "#.###.#..###.#.#..##.....#\n" +
          "##.#.#.##.#......#####..##\n" +
          "#..##.#.##..###.##.###..##\n" +
          "#..#.###...#.#...#..#.##.#\n" +
          ".#..#.#....###.#.#..##.#.#\n" +
          "#.##.#####..###...#.###.##\n" +
          "#...##..#..##.##.#.##..###\n" +
          "#.#.###.###.....####.##..#\n" +
          "######....#.#X....###.#..#\n" +
          "..##.#.####.....###..##.#.\n" +
          "#..#..#...#.####..######..\n" +
          "#####.##...#.#....#....#.#\n" +
          ".#####.##.#.#####..##.#...\n" +
          "#..##..##.#.##.##.####..##\n" +
          ".##..####..#..####.#######\n" +
          "#.#..#.##.#.######....##..\n" +
          ".#.##.##.####......#.##.##");

        assertEquals(new Asteroid(6,12), monitoringStation.asteroidToBeDestroyedAt(200));
    }
}