/*
 * Musicdroid: An on-device music generator for Android
 * Copyright (C) 2010-2014 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * An additional term exception under section 7 of the GNU Affero
 * General Public License, version 3, is available at
 * http://developer.catrobat.org/license_additional_term
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.catrobat.musicdroid.pocketmusic.test.note;

import android.test.AndroidTestCase;

import org.catrobat.musicdroid.pocketmusic.note.NoteFlag;
import org.catrobat.musicdroid.pocketmusic.note.NoteLength;
import org.catrobat.musicdroid.pocketmusic.note.Project;

public class NoteLengthTest extends AndroidTestCase {

    public void testToTicks1() {
        long expectedTicks = 384 / 48 * Project.DEFAULT_BEATS_PER_MINUTE;
        long actualTicks = NoteLength.QUARTER.toTicks(Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedTicks, actualTicks);
    }

    public void testToTicks2() {
        long expectedTicks = 384 / 48 * 2 * Project.DEFAULT_BEATS_PER_MINUTE;
        long actualTicks = NoteLength.HALF.toTicks(Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedTicks, actualTicks);
    }

    public void testToMilliseconds1() {
        long expectedMilliseconds = 1000;
        long actualMilliseconds = NoteLength.QUARTER.toMilliseconds(Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedMilliseconds, actualMilliseconds);
    }

    public void testToMilliseconds2() {
        long expectedMilliseconds = 2000;
        long actualMilliseconds = NoteLength.HALF.toMilliseconds(Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedMilliseconds, actualMilliseconds);
    }

    public void testGetNoteLengthFromTick1() {
        NoteLength expectedNoteLength = NoteLength.WHOLE_DOT;
        long duration = expectedNoteLength.toTicks(Project.DEFAULT_BEATS_PER_MINUTE);

        NoteLength actualNoteLength = NoteLength.getNoteLengthFromTickDuration(duration, Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedNoteLength, actualNoteLength);
    }

    public void testGetNoteLengthFromTick2() {
        NoteLength expectedNoteLength = NoteLength.WHOLE_DOT;
        long duration = expectedNoteLength.toTicks(Project.DEFAULT_BEATS_PER_MINUTE);
        duration += 1;

        NoteLength actualNoteLength = NoteLength.getNoteLengthFromTickDuration(duration, Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedNoteLength, actualNoteLength);
    }

    public void testGetNoteLengthFromTick3() {
        NoteLength expectedNoteLength = NoteLength.QUARTER;
        long duration = NoteLength.QUARTER_DOT.toTicks(Project.DEFAULT_BEATS_PER_MINUTE);
        duration -= 1;

        NoteLength actualNoteLength = NoteLength.getNoteLengthFromTickDuration(duration, Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedNoteLength, actualNoteLength);
    }

    public void testGetNoteLengthFromTick4() {
        NoteLength expectedNoteLength = NoteLength.QUARTER;
        long duration = expectedNoteLength.toTicks(Project.DEFAULT_BEATS_PER_MINUTE);
        duration += 1;

        NoteLength actualNoteLength = NoteLength.getNoteLengthFromTickDuration(duration, Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedNoteLength, actualNoteLength);
    }

    public void testGetNoteLengthFromMilliseconds1() {
        NoteLength expectedNoteLength = NoteLength.QUARTER;
        long millis = 1000;

        NoteLength actualNoteLength = NoteLength.getNoteLengthFromMilliseconds(millis, Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedNoteLength, actualNoteLength);
    }

    public void testGetNoteLengthFromMilliseconds2() {
        NoteLength expectedNoteLength = NoteLength.EIGHT;
        long millis = 510;

        NoteLength actualNoteLength = NoteLength.getNoteLengthFromMilliseconds(millis, Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedNoteLength, actualNoteLength);
    }

    public void testGetNoteLengthFromMilliseconds3() {
        NoteLength expectedNoteLength = NoteLength.SIXTEENTH;
        long millis = 1;

        NoteLength actualNoteLength = NoteLength.getNoteLengthFromMilliseconds(millis, Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedNoteLength, actualNoteLength);
    }

    public void testGetNoteLengthFromMilliseconds4() {
        NoteLength expectedNoteLength = NoteLength.WHOLE_DOT;
        long millis = 10000;

        NoteLength actualNoteLength = NoteLength.getNoteLengthFromMilliseconds(millis, Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedNoteLength, actualNoteLength);
    }

    public void testHasStem1() {
        assertFalse(NoteLength.WHOLE.hasStem());
    }

    public void testHasStem2() {
        assertFalse(NoteLength.WHOLE_DOT.hasStem());
    }

    public void testHasStem3() {
        assertTrue(NoteLength.QUARTER.hasStem());
    }

    public void testHasDot1() {
        assertFalse(NoteLength.QUARTER.hasDot());
    }

    public void testHasDot2() {
        assertTrue(NoteLength.WHOLE_DOT.hasDot());
    }

    public void testHasDot3() {
        assertTrue(NoteLength.HALF_DOT.hasDot());
    }

    public void testHasDot4() {
        assertTrue(NoteLength.QUARTER_DOT.hasDot());
    }

    public void testHasDot5() {
        assertTrue(NoteLength.EIGHT_DOT.hasDot());
    }

    public void testGetFlag1() {
        assertEquals(NoteFlag.NO_FLAG, NoteLength.QUARTER.getFlag());
    }

    public void testGetFlag2() {
        assertEquals(NoteFlag.SINGLE_FLAG, NoteLength.EIGHT.getFlag());
    }

    public void testGetFlag3() {
        assertEquals(NoteFlag.SINGLE_FLAG, NoteLength.EIGHT_DOT.getFlag());
    }

    public void testGetFlag4() {
        assertEquals(NoteFlag.DOUBLE_FLAG, NoteLength.SIXTEENTH.getFlag());
    }

    public void testTickToMilliseconds1() {
        NoteLength noteLength = NoteLength.QUARTER;
        long expectedMilliseconds = noteLength.toMilliseconds(Project.DEFAULT_BEATS_PER_MINUTE);
        long tick = noteLength.toTicks(Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedMilliseconds, NoteLength.tickToMilliseconds(tick));
    }

    public void testTickToMilliseconds2() {
        NoteLength noteLength1 = NoteLength.QUARTER;
        NoteLength noteLength2 = NoteLength.EIGHT;
        long expectedMilliseconds = noteLength1.toMilliseconds(Project.DEFAULT_BEATS_PER_MINUTE)
                + noteLength2.toMilliseconds(Project.DEFAULT_BEATS_PER_MINUTE);
        long tick = noteLength1.toTicks(Project.DEFAULT_BEATS_PER_MINUTE)
                + noteLength2.toTicks(Project.DEFAULT_BEATS_PER_MINUTE);

        assertEquals(expectedMilliseconds, NoteLength.tickToMilliseconds(tick));
    }

    public void testIsHalfOrHigher1() {
        assertTrue(NoteLength.HALF.isHalfOrHigher());
    }

    public void testIsHalfOrHigher2() {
        assertFalse(NoteLength.QUARTER.isHalfOrHigher());
    }
}
