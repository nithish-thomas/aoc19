package nanoFactory;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuelFactoryTest {

    private Stoichiometry day14Input = EquationParser.parse("3 DJDNR => 1 ZCMR\n" +
      "7 VWJH => 5 ZPGT\n" +
      "5 BHZP => 2 DJDNR\n" +
      "6 KCNKC, 19 MZWS => 4 PKVJF\n" +
      "21 GXSHP, 1 TWGP, 3 BGCW => 1 XHRWR\n" +
      "12 DZGWQ, 2 XRDL, 3 XNVT => 2 FTMC\n" +
      "7 VWJH, 33 BGCW, 1 TBVC => 9 DSDP\n" +
      "1 NMTGB, 4 KCNKC, 5 SBSJ, 4 MCZDZ, 7 DLCP, 2 GRBZF, 1 CLKP, 10 VQHJG => 6 DVCR\n" +
      "7 ZCMR => 9 VNTF\n" +
      "2 VNTF, 1 GKMN => 1 TZWBH\n" +
      "6 QMFV, 7 GRBZF => 7 RHDZ\n" +
      "8 PKVJF => 9 NJQH\n" +
      "110 ORE => 9 GZTS\n" +
      "4 DJDNR, 7 SFHV => 8 KQFH\n" +
      "1 ZTCZ, 5 LZFBP => 7 VWPMZ\n" +
      "2 GKMN, 6 TZWBH, 1 GXSHP => 1 MJHJH\n" +
      "2 DLCP, 4 NGJRN => 3 GRBZF\n" +
      "2 DJDNR, 1 GSRBL => 4 VWJH\n" +
      "7 RMQX => 3 SFHV\n" +
      "1 GZTS => 7 GSRBL\n" +
      "3 GZTS, 1 SFHV => 3 QLXCS\n" +
      "10 SFHV => 3 MKTHL\n" +
      "2 DJDNR, 2 BGCW, 4 FSTJ => 3 GKMN\n" +
      "2 KQFH, 7 GSRBL => 7 TWGP\n" +
      "22 RHDZ, 22 DZGWQ, 2 NGJRN, 14 XHRWR, 21 VWPMZ, 15 ZPXHM, 26 BHZP => 8 BPHZ\n" +
      "1 QLXCS => 6 ZBTS\n" +
      "12 DLCP, 9 DSDP => 9 ZPXHM\n" +
      "1 VNTF => 5 ZBTX\n" +
      "2 TZWBH, 2 JCDW => 1 CPLG\n" +
      "1 XHRWR, 7 FSTJ, 5 DZGWQ => 4 NGJRN\n" +
      "179 ORE => 3 RMQX\n" +
      "1 DSDP => 1 MZWS\n" +
      "140 ORE => 8 BHZP\n" +
      "1 LZFBP, 4 DZGWQ => 2 PMDK\n" +
      "1 GZTS => 1 GXSHP\n" +
      "10 CPLG, 8 MCZDZ => 5 ZTCZ\n" +
      "5 ZPGT, 4 THLBN, 24 GSRBL, 40 VNTF, 9 DVCR, 2 SHLP, 11 PMDK, 19 BPHZ, 45 NJQH => 1 FUEL\n" +
      "9 MKTHL => 7 KCNKC\n" +
      "5 NGJRN => 3 QMFV\n" +
      "1 ZTCZ, 6 VNTF => 2 VQHJG\n" +
      "5 FTMC, 5 ZBTX, 1 MJHJH => 1 CLKP\n" +
      "7 FSTJ => 6 DLCP\n" +
      "1 DSDP => 5 KTML\n" +
      "4 LZFBP, 8 MKTHL => 7 MCZDZ\n" +
      "1 SFHV => 1 DZGWQ\n" +
      "2 QLXCS => 4 ZMXRH\n" +
      "3 KQFH, 1 DJDNR => 7 TBVC\n" +
      "5 DSDP => 7 THLBN\n" +
      "9 BHZP, 1 VWJH => 6 BGCW\n" +
      "4 GXSHP => 6 JCDW\n" +
      "1 KQFH, 3 ZMXRH => 9 XNVT\n" +
      "6 TBVC => 4 GVMH\n" +
      "3 VWPMZ, 3 GRBZF, 27 MJHJH, 2 QMFV, 4 NMTGB, 13 KTML => 7 SHLP\n" +
      "1 GVMH => 2 FSTJ\n" +
      "2 VQHJG, 2 NJQH => 8 SBSJ\n" +
      "1 XNVT => 2 XRDL\n" +
      "2 KCNKC => 5 LZFBP\n" +
      "2 ZBTS, 8 DLCP => 4 NMTGB");

    @Test
    public void day14Example1() {
        final Stoichiometry equations = EquationParser.parse("10 ORE => 10 A\n" +
          "1 ORE => 1 B\n" +
          "7 A, 1 B => 1 C\n" +
          "7 A, 1 C => 1 D\n" +
          "7 A, 1 D => 1 E\n" +
          "7 A, 1 E => 1 FUEL");

        final FuelFactory fuelFactory = new FuelFactory(equations);
        final long amountOfOre = fuelFactory.amountOfBaseChemicalRequire(Chemical.getChemical("FUEL"), 1);
        assertEquals(31, amountOfOre);
    }

    @Test
    public void shouldPrintSolDay14_1() {
        final FuelFactory fuelFactory = new FuelFactory(day14Input);
        final long amountOfOre = fuelFactory.amountOfBaseChemicalRequire(Chemical.getChemical("FUEL"), 1);
        assertEquals(371695, amountOfOre);
    }

    @Test
    @Ignore
    public void shouldPrintSolDay14_2() {
        final long ore = 1000000000000L;
        final long oreRequired = oresRequiredForFuel(1);

        final long minFuelCreatable = ore / oreRequired;
        long fuelCreatable = minFuelCreatable;

        while(ore>oresRequiredForFuel(fuelCreatable++));
        final long fuelThatCanBeCreated = fuelCreatable - 2;
        System.out.println(fuelThatCanBeCreated);
        assertEquals(4052920, fuelThatCanBeCreated);
    }

    private long oresRequiredForFuel(long amountRequired) {
        return new FuelFactory(day14Input).amountOfBaseChemicalRequire(Chemical.getChemical("FUEL"), amountRequired);
    }
}