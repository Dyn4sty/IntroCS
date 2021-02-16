package com.maman.fifteen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BigNumberTest {
    BigNumber empty = new BigNumber();

    BigNumber a = new BigNumber(1111111);
    BigNumber b = new BigNumber(6631);
    BigNumber c = new BigNumber(5280);
    BigNumber d = new BigNumber(647);
    BigNumber e = new BigNumber(413);
    BigNumber f = new BigNumber(67);
    BigNumber g = new BigNumber(22);
    BigNumber h = new BigNumber(9);
    BigNumber i = new BigNumber(3);
    BigNumber j = new BigNumber(0);

    BigNumber aa = new BigNumber(a);
    BigNumber bb = new BigNumber(b);
    BigNumber cc = new BigNumber(c);
    BigNumber dd = new BigNumber(d);


    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    @Test
    public void Tester_toString() {

        assertEquals(empty.toString(), "0");

        assertEquals(a.toString(), "1111111");
        assertEquals(b.toString(), "6631");
        assertEquals(c.toString(), "5280");
        assertEquals(d.toString(), "647");
        assertEquals(e.toString(), "413");
        assertEquals(f.toString(), "67");
        assertEquals(g.toString(), "22");
        assertEquals(h.toString(), "9");
        assertEquals(i.toString(), "3");
        assertEquals(j.toString(), "0");

        assertEquals(empty.toString(), j.toString());
        assertEquals(a.toString(), aa.toString());
        assertEquals(b.toString(), bb.toString());
        assertEquals(c.toString(), cc.toString());
        assertEquals(d.toString(), dd.toString());

    }

    @Test
    public void Tester_compareTo() {
        assertEquals(empty.compareTo(a), -1);
        assertEquals(empty.compareTo(b), -1);
        assertEquals(empty.compareTo(c), -1);
        assertEquals(empty.compareTo(d), -1);
        assertEquals(empty.compareTo(e), -1);
        assertEquals(empty.compareTo(f), -1);
        assertEquals(empty.compareTo(g), -1);
        assertEquals(empty.compareTo(h), -1);
        assertEquals(empty.compareTo(i), -1);
        assertEquals(empty.compareTo(j), 0);

        assertEquals(a.compareTo(a), 0);
        assertEquals(a.compareTo(b), 1);
        assertEquals(a.compareTo(c), 1);
        assertEquals(a.compareTo(d), 1);
        assertEquals(a.compareTo(e), 1);
        assertEquals(a.compareTo(f), 1);
        assertEquals(a.compareTo(g), 1);
        assertEquals(a.compareTo(h), 1);
        assertEquals(a.compareTo(i), 1);
        assertEquals(a.compareTo(j), 1);
        assertEquals(a.compareTo(aa), 0);
        assertEquals(a.compareTo(empty), 1);

        assertEquals(b.compareTo(a), -1);
        assertEquals(b.compareTo(b), 0);
        assertEquals(b.compareTo(c), 1);
        assertEquals(b.compareTo(d), 1);
        assertEquals(b.compareTo(e), 1);
        assertEquals(b.compareTo(f), 1);
        assertEquals(b.compareTo(g), 1);
        assertEquals(b.compareTo(h), 1);
        assertEquals(b.compareTo(i), 1);
        assertEquals(b.compareTo(j), 1);
        assertEquals(b.compareTo(aa), -1);
        assertEquals(b.compareTo(bb), 0);
        assertEquals(b.compareTo(empty), 1);

        assertEquals(c.compareTo(a), -1);
        assertEquals(c.compareTo(b), -1);
        assertEquals(c.compareTo(c), 0);
        assertEquals(c.compareTo(d), 1);
        assertEquals(c.compareTo(e), 1);
        assertEquals(c.compareTo(f), 1);
        assertEquals(c.compareTo(g), 1);
        assertEquals(c.compareTo(h), 1);
        assertEquals(c.compareTo(i), 1);
        assertEquals(c.compareTo(j), 1);
        assertEquals(c.compareTo(aa), -1);
        assertEquals(c.compareTo(bb), -1);
        assertEquals(c.compareTo(cc), 0);
        assertEquals(c.compareTo(empty), 1);

        assertEquals(d.compareTo(a), -1);
        assertEquals(d.compareTo(b), -1);
        assertEquals(d.compareTo(c), -1);
        assertEquals(d.compareTo(d), 0);
        assertEquals(d.compareTo(e), 1);
        assertEquals(d.compareTo(f), 1);
        assertEquals(d.compareTo(g), 1);
        assertEquals(d.compareTo(h), 1);
        assertEquals(d.compareTo(i), 1);
        assertEquals(d.compareTo(j), 1);
        assertEquals(d.compareTo(aa), -1);
        assertEquals(d.compareTo(bb), -1);
        assertEquals(d.compareTo(cc), -1);
        assertEquals(d.compareTo(dd), 0);
        assertEquals(d.compareTo(empty), 1);

        assertEquals(e.compareTo(a), -1);
        assertEquals(e.compareTo(b), -1);
        assertEquals(e.compareTo(c), -1);
        assertEquals(e.compareTo(d), -1);
        assertEquals(e.compareTo(e), 0);
        assertEquals(e.compareTo(f), 1);
        assertEquals(e.compareTo(g), 1);
        assertEquals(e.compareTo(h), 1);
        assertEquals(e.compareTo(i), 1);
        assertEquals(e.compareTo(j), 1);
        assertEquals(e.compareTo(aa), -1);
        assertEquals(e.compareTo(bb), -1);
        assertEquals(e.compareTo(cc), -1);
        assertEquals(e.compareTo(dd), -1);
        assertEquals(e.compareTo(empty), 1);

        assertEquals(f.compareTo(a), -1);
        assertEquals(f.compareTo(b), -1);
        assertEquals(f.compareTo(c), -1);
        assertEquals(f.compareTo(d), -1);
        assertEquals(f.compareTo(e), -1);
        assertEquals(f.compareTo(f), 0);
        assertEquals(f.compareTo(g), 1);
        assertEquals(f.compareTo(h), 1);
        assertEquals(f.compareTo(i), 1);
        assertEquals(f.compareTo(j), 1);
        assertEquals(f.compareTo(aa), -1);
        assertEquals(f.compareTo(bb), -1);
        assertEquals(f.compareTo(cc), -1);
        assertEquals(f.compareTo(dd), -1);
        assertEquals(f.compareTo(empty), 1);

        assertEquals(g.compareTo(a), -1);
        assertEquals(g.compareTo(b), -1);
        assertEquals(g.compareTo(c), -1);
        assertEquals(g.compareTo(d), -1);
        assertEquals(g.compareTo(e), -1);
        assertEquals(g.compareTo(f), -1);
        assertEquals(g.compareTo(g), 0);
        assertEquals(g.compareTo(h), 1);
        assertEquals(g.compareTo(i), 1);
        assertEquals(g.compareTo(j), 1);
        assertEquals(g.compareTo(aa), -1);
        assertEquals(g.compareTo(bb), -1);
        assertEquals(g.compareTo(cc), -1);
        assertEquals(g.compareTo(dd), -1);
        assertEquals(g.compareTo(empty), 1);

        assertEquals(h.compareTo(a), -1);
        assertEquals(h.compareTo(b), -1);
        assertEquals(h.compareTo(c), -1);
        assertEquals(h.compareTo(d), -1);
        assertEquals(h.compareTo(e), -1);
        assertEquals(h.compareTo(f), -1);
        assertEquals(h.compareTo(g), -1);
        assertEquals(h.compareTo(h), 0);
        assertEquals(h.compareTo(i), 1);
        assertEquals(h.compareTo(j), 1);
        assertEquals(h.compareTo(aa), -1);
        assertEquals(h.compareTo(bb), -1);
        assertEquals(h.compareTo(cc), -1);
        assertEquals(h.compareTo(dd), -1);
        assertEquals(h.compareTo(empty), 1);

        assertEquals(i.compareTo(a), -1);
        assertEquals(i.compareTo(b), -1);
        assertEquals(i.compareTo(c), -1);
        assertEquals(i.compareTo(d), -1);
        assertEquals(i.compareTo(e), -1);
        assertEquals(i.compareTo(f), -1);
        assertEquals(i.compareTo(g), -1);
        assertEquals(i.compareTo(h), -1);
        assertEquals(i.compareTo(i), 0);
        assertEquals(i.compareTo(j), 1);
        assertEquals(i.compareTo(aa), -1);
        assertEquals(i.compareTo(bb), -1);
        assertEquals(i.compareTo(cc), -1);
        assertEquals(i.compareTo(dd), -1);
        assertEquals(i.compareTo(empty), 1);

        assertEquals(j.compareTo(a), -1);
        assertEquals(j.compareTo(b), -1);
        assertEquals(j.compareTo(c), -1);
        assertEquals(j.compareTo(d), -1);
        assertEquals(j.compareTo(e), -1);
        assertEquals(j.compareTo(f), -1);
        assertEquals(j.compareTo(g), -1);
        assertEquals(j.compareTo(h), -1);
        assertEquals(j.compareTo(i), -1);
        assertEquals(j.compareTo(j), 0);
        assertEquals(j.compareTo(aa), -1);
        assertEquals(j.compareTo(bb), -1);
        assertEquals(j.compareTo(cc), -1);
        assertEquals(j.compareTo(dd), -1);
        assertEquals(j.compareTo(empty), 0);

        assertEquals(bb.compareTo(aa), -1);
        assertEquals(cc.compareTo(dd), 1);
    }

    @Test
    public void Tester_addBigNumber() {
        assertEquals(empty.addBigNumber(a).toString(), "1111111");
        assertEquals(empty.addBigNumber(b).toString(), "6631");
        assertEquals(empty.addBigNumber(c).toString(), "5280");
        assertEquals(empty.addBigNumber(d).toString(), "647");
        assertEquals(empty.addBigNumber(e).toString(), "413");
        assertEquals(empty.addBigNumber(f).toString(), "67");
        assertEquals(empty.addBigNumber(g).toString(), "22");
        assertEquals(empty.addBigNumber(h).toString(), "9");
        assertEquals(empty.addBigNumber(i).toString(), "3");
        assertEquals(empty.addBigNumber(j).toString(), "0");

        assertEquals(a.addBigNumber(a).toString(), "2222222");
        assertEquals(a.addBigNumber(b).toString(), "1117742");
        assertEquals(a.addBigNumber(c).toString(), "1116391");
        assertEquals(a.addBigNumber(d).toString(), "1111758");
        assertEquals(a.addBigNumber(e).toString(), "1111524");
        assertEquals(a.addBigNumber(f).toString(), "1111178");
        assertEquals(a.addBigNumber(g).toString(), "1111133");
        assertEquals(a.addBigNumber(h).toString(), "1111120");
        assertEquals(a.addBigNumber(i).toString(), "1111114");
        assertEquals(a.addBigNumber(j).toString(), "1111111");
        assertEquals(a.addBigNumber(aa).toString(), "2222222");
        assertEquals(a.addBigNumber(empty).toString(), "1111111");

        assertEquals(b.addBigNumber(a).toString(), "1117742");
        assertEquals(b.addBigNumber(b).toString(), "13262");
        assertEquals(b.addBigNumber(c).toString(), "11911");
        assertEquals(b.addBigNumber(d).toString(), "7278");
        assertEquals(b.addBigNumber(e).toString(), "7044");
        assertEquals(b.addBigNumber(f).toString(), "6698");
        assertEquals(b.addBigNumber(g).toString(), "6653");
        assertEquals(b.addBigNumber(h).toString(), "6640");
        assertEquals(b.addBigNumber(i).toString(), "6634");
        assertEquals(b.addBigNumber(j).toString(), "6631");
        assertEquals(b.addBigNumber(aa).toString(), "1117742");
        assertEquals(b.addBigNumber(bb).toString(), "13262");
        assertEquals(b.addBigNumber(empty).toString(), "6631");

        assertEquals(c.addBigNumber(a).toString(), "1116391");
        assertEquals(c.addBigNumber(b).toString(), "11911");
        assertEquals(c.addBigNumber(c).toString(), "10560");
        assertEquals(c.addBigNumber(d).toString(), "5927");
        assertEquals(c.addBigNumber(e).toString(), "5693");
        assertEquals(c.addBigNumber(f).toString(), "5347");
        assertEquals(c.addBigNumber(g).toString(), "5302");
        assertEquals(c.addBigNumber(h).toString(), "5289");
        assertEquals(c.addBigNumber(i).toString(), "5283");
        assertEquals(c.addBigNumber(j).toString(), "5280");
        assertEquals(c.addBigNumber(aa).toString(), "1116391");
        assertEquals(c.addBigNumber(bb).toString(), "11911");
        assertEquals(c.addBigNumber(cc).toString(), "10560");
        assertEquals(c.addBigNumber(empty).toString(), "5280");

        assertEquals(d.addBigNumber(a).toString(), "1111758");
        assertEquals(d.addBigNumber(b).toString(), "7278");
        assertEquals(d.addBigNumber(c).toString(), "5927");
        assertEquals(d.addBigNumber(d).toString(), "1294");
        assertEquals(d.addBigNumber(e).toString(), "1060");
        assertEquals(d.addBigNumber(f).toString(), "714");
        assertEquals(d.addBigNumber(g).toString(), "669");
        assertEquals(d.addBigNumber(h).toString(), "656");
        assertEquals(d.addBigNumber(i).toString(), "650");
        assertEquals(d.addBigNumber(j).toString(), "647");
        assertEquals(d.addBigNumber(aa).toString(), "1111758");
        assertEquals(d.addBigNumber(bb).toString(), "7278");
        assertEquals(d.addBigNumber(cc).toString(), "5927");
        assertEquals(d.addBigNumber(dd).toString(), "1294");
        assertEquals(d.addBigNumber(empty).toString(), "647");

        assertEquals(e.addBigNumber(a).toString(), "1111524");
        assertEquals(e.addBigNumber(b).toString(), "7044");
        assertEquals(e.addBigNumber(c).toString(), "5693");
        assertEquals(e.addBigNumber(d).toString(), "1060");
        assertEquals(e.addBigNumber(e).toString(), "826");
        assertEquals(e.addBigNumber(f).toString(), "480");
        assertEquals(e.addBigNumber(g).toString(), "435");
        assertEquals(e.addBigNumber(h).toString(), "422");
        assertEquals(e.addBigNumber(i).toString(), "416");
        assertEquals(e.addBigNumber(j).toString(), "413");
        assertEquals(e.addBigNumber(aa).toString(), "1111524");
        assertEquals(e.addBigNumber(bb).toString(), "7044");
        assertEquals(e.addBigNumber(cc).toString(), "5693");
        assertEquals(e.addBigNumber(dd).toString(), "1060");
        assertEquals(e.addBigNumber(empty).toString(), "413");

        assertEquals(f.addBigNumber(a).toString(), "1111178");
        assertEquals(f.addBigNumber(b).toString(), "6698");
        assertEquals(f.addBigNumber(c).toString(), "5347");
        assertEquals(f.addBigNumber(d).toString(), "714");
        assertEquals(f.addBigNumber(e).toString(), "480");
        assertEquals(f.addBigNumber(f).toString(), "134");
        assertEquals(f.addBigNumber(g).toString(), "89");
        assertEquals(f.addBigNumber(h).toString(), "76");
        assertEquals(f.addBigNumber(i).toString(), "70");
        assertEquals(f.addBigNumber(j).toString(), "67");
        assertEquals(f.addBigNumber(aa).toString(), "1111178");
        assertEquals(f.addBigNumber(bb).toString(), "6698");
        assertEquals(f.addBigNumber(cc).toString(), "5347");
        assertEquals(f.addBigNumber(dd).toString(), "714");
        assertEquals(f.addBigNumber(empty).toString(), "67");

        assertEquals(g.addBigNumber(a).toString(), "1111133");
        assertEquals(g.addBigNumber(b).toString(), "6653");
        assertEquals(g.addBigNumber(c).toString(), "5302");
        assertEquals(g.addBigNumber(d).toString(), "669");
        assertEquals(g.addBigNumber(e).toString(), "435");
        assertEquals(g.addBigNumber(f).toString(), "89");
        assertEquals(g.addBigNumber(g).toString(), "44");
        assertEquals(g.addBigNumber(h).toString(), "31");
        assertEquals(g.addBigNumber(i).toString(), "25");
        assertEquals(g.addBigNumber(j).toString(), "22");
        assertEquals(g.addBigNumber(aa).toString(), "1111133");
        assertEquals(g.addBigNumber(bb).toString(), "6653");
        assertEquals(g.addBigNumber(cc).toString(), "5302");
        assertEquals(g.addBigNumber(dd).toString(), "669");
        assertEquals(g.addBigNumber(empty).toString(), "22");

        assertEquals(h.addBigNumber(a).toString(), "1111120");
        assertEquals(h.addBigNumber(b).toString(), "6640");
        assertEquals(h.addBigNumber(c).toString(), "5289");
        assertEquals(h.addBigNumber(d).toString(), "656");
        assertEquals(h.addBigNumber(e).toString(), "422");
        assertEquals(h.addBigNumber(f).toString(), "76");
        assertEquals(h.addBigNumber(g).toString(), "31");
        assertEquals(h.addBigNumber(h).toString(), "18");
        assertEquals(h.addBigNumber(i).toString(), "12");
        assertEquals(h.addBigNumber(j).toString(), "9");
        assertEquals(h.addBigNumber(aa).toString(), "1111120");
        assertEquals(h.addBigNumber(bb).toString(), "6640");
        assertEquals(h.addBigNumber(cc).toString(), "5289");
        assertEquals(h.addBigNumber(dd).toString(), "656");
        assertEquals(h.addBigNumber(empty).toString(), "9");

        assertEquals(i.addBigNumber(a).toString(), "1111114");
        assertEquals(i.addBigNumber(b).toString(), "6634");
        assertEquals(i.addBigNumber(c).toString(), "5283");
        assertEquals(i.addBigNumber(d).toString(), "650");
        assertEquals(i.addBigNumber(e).toString(), "416");
        assertEquals(i.addBigNumber(f).toString(), "70");
        assertEquals(i.addBigNumber(g).toString(), "25");
        assertEquals(i.addBigNumber(h).toString(), "12");
        assertEquals(i.addBigNumber(i).toString(), "6");
        assertEquals(i.addBigNumber(j).toString(), "3");
        assertEquals(i.addBigNumber(aa).toString(), "1111114");
        assertEquals(i.addBigNumber(bb).toString(), "6634");
        assertEquals(i.addBigNumber(cc).toString(), "5283");
        assertEquals(i.addBigNumber(dd).toString(), "650");
        assertEquals(i.addBigNumber(empty).toString(), "3");

        assertEquals(j.addBigNumber(a).toString(), "1111111");
        assertEquals(j.addBigNumber(b).toString(), "6631");
        assertEquals(j.addBigNumber(c).toString(), "5280");
        assertEquals(j.addBigNumber(d).toString(), "647");
        assertEquals(j.addBigNumber(e).toString(), "413");
        assertEquals(j.addBigNumber(f).toString(), "67");
        assertEquals(j.addBigNumber(g).toString(), "22");
        assertEquals(j.addBigNumber(h).toString(), "9");
        assertEquals(j.addBigNumber(i).toString(), "3");
        assertEquals(j.addBigNumber(j).toString(), "0");
        assertEquals(j.addBigNumber(aa).toString(), "1111111");
        assertEquals(j.addBigNumber(bb).toString(), "6631");
        assertEquals(j.addBigNumber(cc).toString(), "5280");
        assertEquals(j.addBigNumber(dd).toString(), "647");
        assertEquals(j.addBigNumber(empty).toString(), "0");

        assertEquals(bb.addBigNumber(aa).toString(), "1117742");
        assertEquals(cc.addBigNumber(dd).toString(), "5927");
    }


    @Test
    public void Tester_addLong() {
        long numA = 1111111;
        long numB = 6631;
        long numC = 5280;
        long numD = 647;
        long numE = 413;
        long numF = 67;
        long numG = 22;
        long numH = 9;
        long numI = 3;
        long numJ = 0;

        assertEquals(empty.addLong(numA).toString(), "1111111");
        assertEquals(empty.addLong(numB).toString(), "6631");
        assertEquals(empty.addLong(numC).toString(), "5280");
        assertEquals(empty.addLong(numD).toString(), "647");
        assertEquals(empty.addLong(numE).toString(), "413");
        assertEquals(empty.addLong(numF).toString(), "67");
        assertEquals(empty.addLong(numG).toString(), "22");
        assertEquals(empty.addLong(numH).toString(), "9");
        assertEquals(empty.addLong(numI).toString(), "3");
        assertEquals(empty.addLong(numJ).toString(), "0");

        assertEquals(a.addLong(numA).toString(), "2222222");
        assertEquals(a.addLong(numB).toString(), "1117742");
        assertEquals(a.addLong(numC).toString(), "1116391");
        assertEquals(a.addLong(numD).toString(), "1111758");
        assertEquals(a.addLong(numE).toString(), "1111524");
        assertEquals(a.addLong(numF).toString(), "1111178");
        assertEquals(a.addLong(numG).toString(), "1111133");
        assertEquals(a.addLong(numH).toString(), "1111120");
        assertEquals(a.addLong(numI).toString(), "1111114");
        assertEquals(a.addLong(numJ).toString(), "1111111");

        assertEquals(b.addLong(numA).toString(), "1117742");
        assertEquals(b.addLong(numB).toString(), "13262");
        assertEquals(b.addLong(numC).toString(), "11911");
        assertEquals(b.addLong(numD).toString(), "7278");
        assertEquals(b.addLong(numE).toString(), "7044");
        assertEquals(b.addLong(numF).toString(), "6698");
        assertEquals(b.addLong(numG).toString(), "6653");
        assertEquals(b.addLong(numH).toString(), "6640");
        assertEquals(b.addLong(numI).toString(), "6634");
        assertEquals(b.addLong(numJ).toString(), "6631");

        assertEquals(c.addLong(numA).toString(), "1116391");
        assertEquals(c.addLong(numB).toString(), "11911");
        assertEquals(c.addLong(numC).toString(), "10560");
        assertEquals(c.addLong(numD).toString(), "5927");
        assertEquals(c.addLong(numE).toString(), "5693");
        assertEquals(c.addLong(numF).toString(), "5347");
        assertEquals(c.addLong(numG).toString(), "5302");
        assertEquals(c.addLong(numH).toString(), "5289");
        assertEquals(c.addLong(numI).toString(), "5283");
        assertEquals(c.addLong(numJ).toString(), "5280");

        assertEquals(d.addLong(numA).toString(), "1111758");
        assertEquals(d.addLong(numB).toString(), "7278");
        assertEquals(d.addLong(numC).toString(), "5927");
        assertEquals(d.addLong(numD).toString(), "1294");
        assertEquals(d.addLong(numE).toString(), "1060");
        assertEquals(d.addLong(numF).toString(), "714");
        assertEquals(d.addLong(numG).toString(), "669");
        assertEquals(d.addLong(numH).toString(), "656");
        assertEquals(d.addLong(numI).toString(), "650");
        assertEquals(d.addLong(numJ).toString(), "647");

        assertEquals(e.addLong(numA).toString(), "1111524");
        assertEquals(e.addLong(numB).toString(), "7044");
        assertEquals(e.addLong(numC).toString(), "5693");
        assertEquals(e.addLong(numD).toString(), "1060");
        assertEquals(e.addLong(numE).toString(), "826");
        assertEquals(e.addLong(numF).toString(), "480");
        assertEquals(e.addLong(numG).toString(), "435");
        assertEquals(e.addLong(numH).toString(), "422");
        assertEquals(e.addLong(numI).toString(), "416");
        assertEquals(e.addLong(numJ).toString(), "413");

        assertEquals(f.addLong(numA).toString(), "1111178");
        assertEquals(f.addLong(numB).toString(), "6698");
        assertEquals(f.addLong(numC).toString(), "5347");
        assertEquals(f.addLong(numD).toString(), "714");
        assertEquals(f.addLong(numE).toString(), "480");
        assertEquals(f.addLong(numF).toString(), "134");
        assertEquals(f.addLong(numG).toString(), "89");
        assertEquals(f.addLong(numH).toString(), "76");
        assertEquals(f.addLong(numI).toString(), "70");
        assertEquals(f.addLong(numJ).toString(), "67");

        assertEquals(g.addLong(numA).toString(), "1111133");
        assertEquals(g.addLong(numB).toString(), "6653");
        assertEquals(g.addLong(numC).toString(), "5302");
        assertEquals(g.addLong(numD).toString(), "669");
        assertEquals(g.addLong(numE).toString(), "435");
        assertEquals(g.addLong(numF).toString(), "89");
        assertEquals(g.addLong(numG).toString(), "44");
        assertEquals(g.addLong(numH).toString(), "31");
        assertEquals(g.addLong(numI).toString(), "25");
        assertEquals(g.addLong(numJ).toString(), "22");

        assertEquals(h.addLong(numA).toString(), "1111120");
        assertEquals(h.addLong(numB).toString(), "6640");
        assertEquals(h.addLong(numC).toString(), "5289");
        assertEquals(h.addLong(numD).toString(), "656");
        assertEquals(h.addLong(numE).toString(), "422");
        assertEquals(h.addLong(numF).toString(), "76");
        assertEquals(h.addLong(numG).toString(), "31");
        assertEquals(h.addLong(numH).toString(), "18");
        assertEquals(h.addLong(numI).toString(), "12");
        assertEquals(h.addLong(numJ).toString(), "9");

        assertEquals(i.addLong(numA).toString(), "1111114");
        assertEquals(i.addLong(numB).toString(), "6634");
        assertEquals(i.addLong(numC).toString(), "5283");
        assertEquals(i.addLong(numD).toString(), "650");
        assertEquals(i.addLong(numE).toString(), "416");
        assertEquals(i.addLong(numF).toString(), "70");
        assertEquals(i.addLong(numG).toString(), "25");
        assertEquals(i.addLong(numH).toString(), "12");
        assertEquals(i.addLong(numI).toString(), "6");
        assertEquals(i.addLong(numJ).toString(), "3");

        assertEquals(j.addLong(numA).toString(), "1111111");
        assertEquals(j.addLong(numB).toString(), "6631");
        assertEquals(j.addLong(numC).toString(), "5280");
        assertEquals(j.addLong(numD).toString(), "647");
        assertEquals(j.addLong(numE).toString(), "413");
        assertEquals(j.addLong(numF).toString(), "67");
        assertEquals(j.addLong(numG).toString(), "22");
        assertEquals(j.addLong(numH).toString(), "9");
        assertEquals(j.addLong(numI).toString(), "3");
        assertEquals(j.addLong(numJ).toString(), "0");
    }

    @Test
    public void Tester_subtractBigNumber() {
        assertEquals(empty.subtractBigNumber(a).toString(), "1111111");
        assertEquals(empty.subtractBigNumber(b).toString(), "6631");
        assertEquals(empty.subtractBigNumber(c).toString(), "5280");
        assertEquals(empty.subtractBigNumber(d).toString(), "647");
        assertEquals(empty.subtractBigNumber(e).toString(), "413");
        assertEquals(empty.subtractBigNumber(f).toString(), "67");
        assertEquals(empty.subtractBigNumber(g).toString(), "22");
        assertEquals(empty.subtractBigNumber(h).toString(), "9");
        assertEquals(empty.subtractBigNumber(i).toString(), "3");
        assertEquals(empty.subtractBigNumber(j).toString(), "0");

        assertEquals(a.subtractBigNumber(a).toString(), "0");
        assertEquals(a.subtractBigNumber(b).toString(), "1104480");
        assertEquals(a.subtractBigNumber(c).toString(), "1105831");
        assertEquals(a.subtractBigNumber(d).toString(), "1110464");
        assertEquals(a.subtractBigNumber(e).toString(), "1110698");
        assertEquals(a.subtractBigNumber(f).toString(), "1111044");
        assertEquals(a.subtractBigNumber(g).toString(), "1111089");
        assertEquals(a.subtractBigNumber(h).toString(), "1111102");
        assertEquals(a.subtractBigNumber(i).toString(), "1111108");
        assertEquals(a.subtractBigNumber(j).toString(), "1111111");
        assertEquals(a.subtractBigNumber(aa).toString(), "0");
        assertEquals(a.subtractBigNumber(empty).toString(), "1111111");

        assertEquals(b.subtractBigNumber(a).toString(), "1104480");
        assertEquals(b.subtractBigNumber(b).toString(), "0");
        assertEquals(b.subtractBigNumber(c).toString(), "1351");
        assertEquals(b.subtractBigNumber(d).toString(), "5984");
        assertEquals(b.subtractBigNumber(e).toString(), "6218");
        assertEquals(b.subtractBigNumber(f).toString(), "6564");
        assertEquals(b.subtractBigNumber(g).toString(), "6609");
        assertEquals(b.subtractBigNumber(h).toString(), "6622");
        assertEquals(b.subtractBigNumber(i).toString(), "6628");
        assertEquals(b.subtractBigNumber(j).toString(), "6631");
        assertEquals(b.subtractBigNumber(aa).toString(), "1104480");
        assertEquals(b.subtractBigNumber(bb).toString(), "0");
        assertEquals(b.subtractBigNumber(empty).toString(), "6631");

        assertEquals(c.subtractBigNumber(a).toString(), "1105831");
        assertEquals(c.subtractBigNumber(b).toString(), "1351");
        assertEquals(c.subtractBigNumber(c).toString(), "0");
        assertEquals(c.subtractBigNumber(d).toString(), "4633");
        assertEquals(c.subtractBigNumber(e).toString(), "4867");
        assertEquals(c.subtractBigNumber(f).toString(), "5213");
        assertEquals(c.subtractBigNumber(g).toString(), "5258");
        assertEquals(c.subtractBigNumber(h).toString(), "5271");
        assertEquals(c.subtractBigNumber(i).toString(), "5277");
        assertEquals(c.subtractBigNumber(j).toString(), "5280");
        assertEquals(c.subtractBigNumber(aa).toString(), "1105831");
        assertEquals(c.subtractBigNumber(bb).toString(), "1351");
        assertEquals(c.subtractBigNumber(cc).toString(), "0");
        assertEquals(c.subtractBigNumber(empty).toString(), "5280");

        assertEquals(d.subtractBigNumber(a).toString(), "1110464");
        assertEquals(d.subtractBigNumber(b).toString(), "5984");
        assertEquals(d.subtractBigNumber(c).toString(), "4633");
        assertEquals(d.subtractBigNumber(d).toString(), "0");
        assertEquals(d.subtractBigNumber(e).toString(), "234");
        assertEquals(d.subtractBigNumber(f).toString(), "580");
        assertEquals(d.subtractBigNumber(g).toString(), "625");
        assertEquals(d.subtractBigNumber(h).toString(), "638");
        assertEquals(d.subtractBigNumber(i).toString(), "644");
        assertEquals(d.subtractBigNumber(j).toString(), "647");
        assertEquals(d.subtractBigNumber(aa).toString(), "1110464");
        assertEquals(d.subtractBigNumber(bb).toString(), "5984");
        assertEquals(d.subtractBigNumber(cc).toString(), "4633");
        assertEquals(d.subtractBigNumber(dd).toString(), "0");
        assertEquals(d.subtractBigNumber(empty).toString(), "647");

        assertEquals(e.subtractBigNumber(a).toString(), "1110698");
        assertEquals(e.subtractBigNumber(b).toString(), "6218");
        assertEquals(e.subtractBigNumber(c).toString(), "4867");
        assertEquals(e.subtractBigNumber(d).toString(), "234");
        assertEquals(e.subtractBigNumber(e).toString(), "0");
        assertEquals(e.subtractBigNumber(f).toString(), "346");
        assertEquals(e.subtractBigNumber(g).toString(), "391");
        assertEquals(e.subtractBigNumber(h).toString(), "404");
        assertEquals(e.subtractBigNumber(i).toString(), "410");
        assertEquals(e.subtractBigNumber(j).toString(), "413");
        assertEquals(e.subtractBigNumber(aa).toString(), "1110698");
        assertEquals(e.subtractBigNumber(bb).toString(), "6218");
        assertEquals(e.subtractBigNumber(cc).toString(), "4867");
        assertEquals(e.subtractBigNumber(dd).toString(), "234");
        assertEquals(e.subtractBigNumber(empty).toString(), "413");

        assertEquals(f.subtractBigNumber(a).toString(), "1111044");
        assertEquals(f.subtractBigNumber(b).toString(), "6564");
        assertEquals(f.subtractBigNumber(c).toString(), "5213");
        assertEquals(f.subtractBigNumber(d).toString(), "580");
        assertEquals(f.subtractBigNumber(e).toString(), "346");
        assertEquals(f.subtractBigNumber(f).toString(), "0");
        assertEquals(f.subtractBigNumber(g).toString(), "45");
        assertEquals(f.subtractBigNumber(h).toString(), "58");
        assertEquals(f.subtractBigNumber(i).toString(), "64");
        assertEquals(f.subtractBigNumber(j).toString(), "67");
        assertEquals(f.subtractBigNumber(aa).toString(), "1111044");
        assertEquals(f.subtractBigNumber(bb).toString(), "6564");
        assertEquals(f.subtractBigNumber(cc).toString(), "5213");
        assertEquals(f.subtractBigNumber(dd).toString(), "580");
        assertEquals(f.subtractBigNumber(empty).toString(), "67");

        assertEquals(g.subtractBigNumber(a).toString(), "1111089");
        assertEquals(g.subtractBigNumber(b).toString(), "6609");
        assertEquals(g.subtractBigNumber(c).toString(), "5258");
        assertEquals(g.subtractBigNumber(d).toString(), "625");
        assertEquals(g.subtractBigNumber(e).toString(), "391");
        assertEquals(g.subtractBigNumber(f).toString(), "45");
        assertEquals(g.subtractBigNumber(g).toString(), "0");
        assertEquals(g.subtractBigNumber(h).toString(), "13");
        assertEquals(g.subtractBigNumber(i).toString(), "19");
        assertEquals(g.subtractBigNumber(j).toString(), "22");
        assertEquals(g.subtractBigNumber(aa).toString(), "1111089");
        assertEquals(g.subtractBigNumber(bb).toString(), "6609");
        assertEquals(g.subtractBigNumber(cc).toString(), "5258");
        assertEquals(g.subtractBigNumber(dd).toString(), "625");
        assertEquals(g.subtractBigNumber(empty).toString(), "22");

        assertEquals(h.subtractBigNumber(a).toString(), "1111102");
        assertEquals(h.subtractBigNumber(b).toString(), "6622");
        assertEquals(h.subtractBigNumber(c).toString(), "5271");
        assertEquals(h.subtractBigNumber(d).toString(), "638");
        assertEquals(h.subtractBigNumber(e).toString(), "404");
        assertEquals(h.subtractBigNumber(f).toString(), "58");
        assertEquals(h.subtractBigNumber(g).toString(), "13");
        assertEquals(h.subtractBigNumber(h).toString(), "0");
        assertEquals(h.subtractBigNumber(i).toString(), "6");
        assertEquals(h.subtractBigNumber(j).toString(), "9");
        assertEquals(h.subtractBigNumber(aa).toString(), "1111102");
        assertEquals(h.subtractBigNumber(bb).toString(), "6622");
        assertEquals(h.subtractBigNumber(cc).toString(), "5271");
        assertEquals(h.subtractBigNumber(dd).toString(), "638");
        assertEquals(h.subtractBigNumber(empty).toString(), "9");

        assertEquals(i.subtractBigNumber(a).toString(), "1111108");
        assertEquals(i.subtractBigNumber(b).toString(), "6628");
        assertEquals(i.subtractBigNumber(c).toString(), "5277");
        assertEquals(i.subtractBigNumber(d).toString(), "644");
        assertEquals(i.subtractBigNumber(e).toString(), "410");
        assertEquals(i.subtractBigNumber(f).toString(), "64");
        assertEquals(i.subtractBigNumber(g).toString(), "19");
        assertEquals(i.subtractBigNumber(h).toString(), "6");
        assertEquals(i.subtractBigNumber(i).toString(), "0");
        assertEquals(i.subtractBigNumber(j).toString(), "3");
        assertEquals(i.subtractBigNumber(aa).toString(), "1111108");
        assertEquals(i.subtractBigNumber(bb).toString(), "6628");
        assertEquals(i.subtractBigNumber(cc).toString(), "5277");
        assertEquals(i.subtractBigNumber(dd).toString(), "644");
        assertEquals(i.subtractBigNumber(empty).toString(), "3");

        assertEquals(j.subtractBigNumber(a).toString(), "1111111");
        assertEquals(j.subtractBigNumber(b).toString(), "6631");
        assertEquals(j.subtractBigNumber(c).toString(), "5280");
        assertEquals(j.subtractBigNumber(d).toString(), "647");
        assertEquals(j.subtractBigNumber(e).toString(), "413");
        assertEquals(j.subtractBigNumber(f).toString(), "67");
        assertEquals(j.subtractBigNumber(g).toString(), "22");
        assertEquals(j.subtractBigNumber(h).toString(), "9");
        assertEquals(j.subtractBigNumber(i).toString(), "3");
        assertEquals(j.subtractBigNumber(j).toString(), "0");
        assertEquals(j.subtractBigNumber(aa).toString(), "1111111");
        assertEquals(j.subtractBigNumber(bb).toString(), "6631");
        assertEquals(j.subtractBigNumber(cc).toString(), "5280");
        assertEquals(j.subtractBigNumber(dd).toString(), "647");
        assertEquals(j.subtractBigNumber(empty).toString(), "0");

        assertEquals(bb.subtractBigNumber(aa).toString(), "1104480");
        assertEquals(cc.subtractBigNumber(dd).toString(), "4633");

    }

    @Test
    public void Tester_multBigNumber() {
        assertEquals(empty.multBigNumber(a).toString(), "0");
        assertEquals(empty.multBigNumber(b).toString(), "0");
        assertEquals(empty.multBigNumber(c).toString(), "0");
        assertEquals(empty.multBigNumber(d).toString(), "0");
        assertEquals(empty.multBigNumber(e).toString(), "0");
        assertEquals(empty.multBigNumber(f).toString(), "0");
        assertEquals(empty.multBigNumber(g).toString(), "0");
        assertEquals(empty.multBigNumber(h).toString(), "0");
        assertEquals(empty.multBigNumber(i).toString(), "0");
        assertEquals(empty.multBigNumber(j).toString(), "0");

        assertEquals(i.multBigNumber(i).toString(), "9");
        assertEquals(h.multBigNumber(i).toString(), "27");
        assertEquals(h.multBigNumber(h).toString(), "81");
        assertEquals(g.multBigNumber(i).toString(), "66");
        assertEquals(g.multBigNumber(h).toString(), "198");
        assertEquals(g.multBigNumber(g).toString(), "484");
        assertEquals(f.multBigNumber(i).toString(), "201");
        assertEquals(f.multBigNumber(h).toString(), "603");
        assertEquals(f.multBigNumber(g).toString(), "1474"); // we were failing here
        assertEquals(f.multBigNumber(f).toString(), "4489");
        assertEquals(e.multBigNumber(i).toString(), "1239");
        assertEquals(e.multBigNumber(h).toString(), "3717");
        assertEquals(e.multBigNumber(g).toString(), "9086");
        assertEquals(e.multBigNumber(f).toString(), "27671");
        assertEquals(e.multBigNumber(e).toString(), "170569");

        assertEquals(a.multBigNumber(b).toString(), "7367777041");
        /*
        assertEquals(a.multiBigNumber(c).toString(), "");
        assertEquals(a.multiBigNumber(d).toString(), "");
        assertEquals(a.multBigNumber(e).toString(), "");
        assertEquals(a.multBigNumber(f).toString(), "");
        assertEquals(a.multBigNumber(g).toString(), "");
        assertEquals(a.multBigNumber(h).toString(), "");
        assertEquals(a.multBigNumber(i).toString(), "");

        assertEquals(b.multBigNumber(b).toString(), "");
        assertEquals(b.multBigNumber(c).toString(), "");
        assertEquals(b.multBigNumber(d).toString(), "");
        assertEquals(b.multBigNumber(e).toString(), "");
        assertEquals(b.multBigNumber(f).toString(), "");
        assertEquals(b.multBigNumber(g).toString(), "");
        assertEquals(b.multBigNumber(h).toString(), "");
        assertEquals(b.multBigNumber(i).toString(), "");

        assertEquals(c.multBigNumber(c).toString(), "");
        assertEquals(c.multBigNumber(d).toString(), "");
        assertEquals(c.multBigNumber(e).toString(), "");
        assertEquals(c.multBigNumber(f).toString(), "");
        assertEquals(c.multBigNumber(g).toString(), "");
        assertEquals(c.multBigNumber(h).toString(), "");
        assertEquals(c.multBigNumber(i).toString(), "");

        assertEquals(d.multBigNumber(d).toString(), "");
        assertEquals(d.multBigNumber(e).toString(), "");
        assertEquals(d.multBigNumber(f).toString(), "");
        assertEquals(d.multBigNumber(g).toString(), "");
        assertEquals(d.multBigNumber(h).toString(), "");
        assertEquals(d.multBigNumber(i).toString(), "");
        */

        assertEquals(j.multBigNumber(a).toString(), "0");
        assertEquals(j.multBigNumber(b).toString(), "0");
        assertEquals(j.multBigNumber(c).toString(), "0");
        assertEquals(j.multBigNumber(d).toString(), "0");
        assertEquals(j.multBigNumber(e).toString(), "0");
        assertEquals(j.multBigNumber(f).toString(), "0");
        assertEquals(j.multBigNumber(g).toString(), "0");
        assertEquals(j.multBigNumber(h).toString(), "0");
        assertEquals(j.multBigNumber(i).toString(), "0");
        assertEquals(j.multBigNumber(j).toString(), "0");
        assertEquals(j.multBigNumber(aa).toString(), "0");
        assertEquals(j.multBigNumber(bb).toString(), "0");
        assertEquals(j.multBigNumber(cc).toString(), "0");
        assertEquals(j.multBigNumber(dd).toString(), "0");
        assertEquals(j.multBigNumber(empty).toString(), "0");

        assertEquals(bb.multBigNumber(aa).toString(), "7367777041");
        assertEquals(cc.multBigNumber(dd).toString(), "3416160");
    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
}
