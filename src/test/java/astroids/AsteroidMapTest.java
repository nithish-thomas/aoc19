package astroids;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AsteroidMapTest {
    @Test
    public void shoulHaveBestAsteroidAt3_4() {
        final AsteroidMap asteroidMap = AsteroidMap.create(".#..#\n" +
          ".....\n" +
          "#####\n" +
          "....#\n" +
          "...##");

        final BestAsteroid best = asteroidMap.best();


        assertEquals(8,best.count);
        assertEquals(new Asteroid(3,4),best.asteroid);
    }


    @Test
    public void shoulHaveBestAsteroidAt5_8_33() {
        final AsteroidMap asteroidMap = AsteroidMap.create("......#.#.\n" +
          "#..#.#....\n" +
          "..#######.\n" +
          ".#.#.###..\n" +
          ".#..#.....\n" +
          "..#....#.#\n" +
          "#..#....#.\n" +
          ".##.#..###\n" +
          "##...#..#.\n" +
          ".#....####");

        final BestAsteroid best = asteroidMap.best();


        assertEquals(33,best.count);
        assertEquals(new Asteroid(5,8),best.asteroid);
    }

    @Test
    public void printDay10_1() {
        final AsteroidMap asteroidMap = AsteroidMap.create("#.#.###.#.#....#..##.#....\n" +
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
          "######....#.##....###.#..#\n" +
          "..##.#.####.....###..##.#.\n" +
          "#..#..#...#.####..######..\n" +
          "#####.##...#.#....#....#.#\n" +
          ".#####.##.#.#####..##.#...\n" +
          "#..##..##.#.##.##.####..##\n" +
          ".##..####..#..####.#######\n" +
          "#.#..#.##.#.######....##..\n" +
          ".#.##.##.####......#.##.##");

        final BestAsteroid best = asteroidMap.best();


        assertEquals(269,best.count);
        assertEquals(new Asteroid(13,17),best.asteroid);
    }
}