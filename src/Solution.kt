/**
 * В теле класса решения разрешено использовать только переменные делегированные в класс RegularInt.
 * Нельзя volatile, нельзя другие типы, нельзя блокировки, нельзя лазить в глобальные переменные.
 *
 * @author Sentemov Lev
 */
class Solution : MonotonicClock {
    private var c1 by RegularInt(0)
    private var c2 by RegularInt(0)
    private var r by RegularInt(0)
    private var l2 by RegularInt(0)
    private var l1 by RegularInt(0)

    override fun write(time: Time) {
        l1 = time.d1
        l2 = time.d2
        r = time.d3
        c2 = time.d2
        c1 = time.d1
    }

    override fun read(): Time {
        val v1 = c1
        val v2 = c2
        val w = r
        val r2 = l2
        val r1 = l1
        return if (v1 == r1) {
            if (v2 == r2) {
                Time(r1, r2, w)
            } else {
                Time(r1, r2, 0)
            }
        } else {
            Time(r1, 0, 0)
        }
    }
}
