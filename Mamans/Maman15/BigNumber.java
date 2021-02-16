package com.maman.fifteen;

/**
 * A BigNumber
 *
 * @author Lior Kashanovsky
 * @version Maman 15
 */
public class BigNumber {
    IntNode _head;

    /* ***********************************************************************************
     *                              Constructors
     ***********************************************************************************/

    /**
     * Empty Constructor for objects of class BigNumber.
     * Construct a new BigNumber with a default value of 0.
     */
    public BigNumber() {
        final IntNode defaultNode = new IntNode(0);
        _head = defaultNode;
    }

    /**
     * Construct a BigNumber object from a long type number
     *
     * @param num a long number to construct from.
     */
    public BigNumber(long num) {
        IntNode ptr = _head;
        do {
            int digit = (int) (num % 10);
            IntNode currentNode = new IntNode(digit);
            if (_head == null) {
                _head = currentNode;
                ptr = currentNode;
            } else {
                ptr.setNext(currentNode);
                ptr = ptr.getNext();
            }
            num /= 10;
        } while (num != 0);

    }

    /**
     * Copy Constructor. Construct a BigNumber object using a reference BigNumber.
     *
     * @param other a number ({@link BigNumber} object) to copy.
     */
    public BigNumber(BigNumber other) {
        this._head = new IntNode(other._head.getValue());
        IntNode otherCurr = other._head.getNext();
        IntNode thisCurr = this._head;
        while (otherCurr != null) {
            thisCurr.setNext(new IntNode(otherCurr.getValue()));
            thisCurr = thisCurr.getNext();
            otherCurr = otherCurr.getNext();
        }

    }


    /* ***********************************************************************************
     *                              Methods
     ***********************************************************************************/

    /**
     * Adding a long num to to a BigNumber object.
     * Complexity Analysis: O(n) Time, O(n) Space
     *
     * @param num a long number  to be summed with.
     * @return The sum of the numbers as {@code BigNumber}
     */
    public BigNumber addLong(long num) {
        /* Creating new Number */
        BigNumber newNumber = null;

        /* Creating Pointers to each Number */
        IntNode thisPtr = this._head;

        // pointer to the current digit in the new number.
        IntNode newNumberPtr = null;

        int carry = 0;

        while (thisPtr != null || num != 0) {
            // add the carry (if exists) and the digits of the two numbers (if any).
            int currentDigit = carry + (thisPtr != null ? thisPtr.getValue() : 0)
                    + (num != 0 ? (int) (num % 10) : 0);

            // Update the carry for the next calculation.
            carry = currentDigit >= 10 ? 1 : 0;

            // Update current value if its greater than 10
            currentDigit %= 10;

            // Initialize the new number
            if (newNumber == null) {
                newNumber = new BigNumber(currentDigit);
                newNumberPtr = newNumber._head;
            } else {
                // we are only initializing it with a value to avoid leading zeros.
                newNumberPtr.setNext(new IntNode(currentDigit));
                newNumberPtr = newNumberPtr.getNext();
            }

            /* Boundary Checks */
            if (thisPtr != null)
                thisPtr = thisPtr.getNext();
            if (num != 0)
                num /= 10;
        }

        if (carry > 0)
            newNumberPtr.setNext(new IntNode(carry));

        return newNumber;
    }

    /**
     * The Addition method of two BigNumber objects.
     * Complexity Analysis: O(n) Time, O(n) Space
     *
     * @param other - a number ({@link BigNumber} object) to be summed with.
     * @return The sum of the numbers as {@code BigNumber}
     */
    public BigNumber addBigNumber(BigNumber other) {
        /* Creating new Number */
        BigNumber newNumber = null;

        /* Creating Pointers to each Number */
        IntNode thisPtr = this._head;
        IntNode otherPtr = other._head;


        // pointer to the current digit in the new number.
        IntNode newNumberPtr = null;

        int carry = 0;

        while (thisPtr != null || otherPtr != null) {
            // add the carry (if exists) and the digits of the two numbers (if any).
            int currentDigit = carry + (thisPtr != null ? thisPtr.getValue() : 0)
                    + (otherPtr != null ? otherPtr.getValue() : 0);

            // Update the carry for the next calculation.
            carry = currentDigit >= 10 ? 1 : 0;

            // Update current value if its greater than 10
            currentDigit %= 10;

            // Initialize the new number
            if (newNumber == null) {
                newNumber = new BigNumber(currentDigit);
                newNumberPtr = newNumber._head;
            } else {
                // we are only initializing it with a value to avoid leading zeros.
                newNumberPtr.setNext(new IntNode(currentDigit));
                newNumberPtr = newNumberPtr.getNext();
            }

            /* Boundary Checks */
            if (thisPtr != null)
                thisPtr = thisPtr.getNext();
            if (otherPtr != null)
                otherPtr = otherPtr.getNext();
        }

        if (carry > 0)
            newNumberPtr.setNext(new IntNode(carry));

        return newNumber;
    }

    /**
     * The subtraction method of two BigNumber objects.
     * <p>
     * (The subtraction is of the larger number of the two, to prevent negative values).
     * Complexity Analysis: O(n) Time, O(n) Space.
     *
     * @param other - a number ({@link BigNumber} object) to subtract.
     * @return The difference of the numbers as {@code BigNumber} object.
     */
    public BigNumber subtractBigNumber(BigNumber other) {
        /* Creating new number */
        BigNumber newNumber = null;
        int borrow = 0;
        IntNode bigger, smaller;

        /* Deciding who is the Bigger Number,*/
        if (this.compareTo(other) == 1) {
            bigger = this._head;
            smaller = other._head;
        } else {
            bigger = other._head;
            smaller = this._head;
        }

        // Flag to validate if the is a Sequence of 0s.
        boolean allZero = true;

        // pointer to the current digit in the new number.
        IntNode newNumberPtr = null;

        while (bigger != null || smaller != null) {
            int currentDigit = borrow + (bigger != null ? bigger.getValue() : 0)
                    - (smaller != null ? smaller.getValue() : 0);

            // Update the borrow for the next calculation
            borrow = currentDigit < 0 ? -1 : 0;

            // Update current value if we borrowed
            if (borrow < 0)
                currentDigit += 10;

            if (currentDigit > 0 && allZero)
                allZero = false;

            // Initialize the new number
            if (newNumber == null) {
                // we are only initializing it with a value to avoid leading zeros.
                newNumber = new BigNumber(currentDigit);
                newNumberPtr = newNumber._head;
            }
            // Add as long as it is not the last digit and is not equal to 0
            // (The number is represented in reverse order, so the last digit can be omitted if it is 0)
            else if (!(currentDigit == 0 && bigger.getNext() == null)) {
                newNumberPtr.setNext(new IntNode(currentDigit));
                newNumberPtr = newNumberPtr.getNext();
            }

            /* Boundary Checks */
            if (bigger != null)
                bigger = bigger.getNext();
            if (smaller != null)
                smaller = smaller.getNext();
        }
        // the numbers is a sequence of zeros, therefore we set it to the last 0
        if (allZero)
            newNumber._head = newNumberPtr;

        return newNumber;
    }

    /**
     * @param other - a number ({@link BigNumber} object) to be multiply with.
     *              Complexity Analysis: O(n*m) Time, O(n) Space.
     * @return The product of the numbers as {@code BigNumber}
     */
    public BigNumber multBigNumber(BigNumber other) {
        /* Creating new Number */
        BigNumber newNumber = null;

        /* Creating Pointers to each Number */

        IntNode newNumberPtr = null;
        /* Deciding who is the Bigger Number,*/
        IntNode bigger, smaller;

        int carry = 0;
        // current digit position
        int idx = 0;
        // Flag to indicate if we should sum the products.
        boolean add = false;

        // Flag to validate if the is a Sequence of 0s.
        boolean allZero = true;
        if (this.compareTo(other) == 1) {
            bigger = this._head;
            smaller = other._head;
        } else {
            bigger = other._head;
            smaller = this._head;
        }

        while (smaller != null) {
            if (newNumber != null) {
                newNumberPtr = newNumber._head;
            }
            IntNode otherPtr = bigger;
            carry = 0;
            while (otherPtr != null) {
                long currentValue = carry + (smaller.getValue() * (int) Math.pow(10, idx) * otherPtr.getValue());

                carry = (int) (currentValue / 10);
                currentValue %= 10;
                if (currentValue > 0 && allZero)
                    allZero = false;
                if (newNumber == null) {
                    newNumber = new BigNumber(currentValue);
                    newNumberPtr = newNumber._head;
                } else {
                    // we are only initializing it with a value to avoid leading zeros.
                    if (add) {
                        currentValue += newNumberPtr.getValue();
                        if (currentValue >= 10) {
                            carry += currentValue / 10;
                            currentValue %= 10;
                        }
                        newNumberPtr.setValue((int) currentValue);
                        if (newNumberPtr.getNext() == null) {
                            add = false;
                            currentValue = carry;
                            carry = 0;
                            if (currentValue > 0 && allZero)
                                allZero = false;
                        }
                    }
                    if (!add) {
                        newNumberPtr.setNext(new IntNode((int) currentValue));

                    }
                    newNumberPtr = newNumberPtr.getNext();
                }
                if (otherPtr.getNext() == null && carry > 0) {
                    if (carry > 10) {
                        int digit = carry % 10;
                        newNumberPtr.setValue(digit + newNumberPtr.getValue());
                        carry /= 10;
                    }
                    allZero = false;
                    newNumberPtr.setNext(new IntNode(carry));

                }
                otherPtr = otherPtr.getNext();
            }
            idx++;
            add = true;
            smaller = smaller.getNext();
        }

        if (allZero) newNumber._head = newNumberPtr;

        return newNumber;
    }


  /* function that works with the add methods */

//    public BigNumber multBigNumber(BigNumber other) {
//        /* Creating new number */
//        BigNumber newNumber = new BigNumber();
//
//        IntNode bigger, smaller;
//
//        if (this.compareTo(other) == -1) {
//            bigger = other._head;
//            smaller = this._head;
//        } else {
//            bigger = this._head;
//            smaller = other._head;
//        }
//        IntNode temp = bigger;
//
//        int idx = 0;
//        while (smaller != null) {
//            // resetting the bigger number.
//            bigger = temp;
//            int pow = 0;
//            for (int j = 0; j < idx; j++) pow++;
//            while (bigger != null) {
//                long product = (long) ((bigger.getValue() * smaller.getValue()) * Math.pow(10, pow));
//                newNumber = newNumber.addLong(product);
//                bigger = bigger.getNext();
//                pow++;
//            }
//            smaller = smaller.getNext();
//            idx++;
//        }
//        return newNumber;
//    }


    /**
     * a string representation of the number's value
     * Complexity Analysis: O(n) Time, O(n) Space
     *
     * @return the number ({@link BigNumber} object) as a string.
     */
    @Override
    public String toString() {
        return toString("", _head);
    }

    // helper function
    private String toString(String s, IntNode curr) {
        if (curr == null)
            return s;
        return toString(curr.getValue() + s, curr.getNext());

    }

    /**
     * Compares two {@code BigNumber} values numerically.
     * Complexity Analysis: O(n) Time, O(1) Space
     *
     * @param other the number {@code BigNumber} to compare with.
     * @return the value {@code 0} if {@code this == other} <br>
     * the value {@code -1} if {@code this < other} <br>
     * and the value {@code 1} if {@code this > other}
     */
    public int compareTo(BigNumber other) {
        /* The numbers have the same length */
        IntNode thisPtr = this._head;
        IntNode otherPtr = other._head;

        int result = 0; // Keep in track which number is bigger.
        while (thisPtr != null && otherPtr != null) {
            int thisValue = thisPtr.getValue();
            int otherValue = otherPtr.getValue();
            if (thisValue > otherValue)
                result = 1;
            else if (thisValue < otherValue)
                result = -1;

            thisPtr = thisPtr.getNext();
            otherPtr = otherPtr.getNext();
        }
        if (thisPtr != null)
            result = 1;
        else if (otherPtr != null)
            result = -1;

        return result;

    }


} // end of class BigNumber
