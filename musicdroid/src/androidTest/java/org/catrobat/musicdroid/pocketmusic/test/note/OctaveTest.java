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

import org.catrobat.musicdroid.pocketmusic.note.NoteName;
import org.catrobat.musicdroid.pocketmusic.note.Octave;

import java.util.Arrays;

public class OctaveTest extends AndroidTestCase {

    public void testGetNoteNames() {
        NoteName[] noteNames = new NoteName[]{
                NoteName.C4, NoteName.C4S, NoteName.D4,
                NoteName.D4S, NoteName.E4, NoteName.F4,
                NoteName.F4S, NoteName.G4, NoteName.G4S,
                NoteName.A4, NoteName.A4S, NoteName.B4};
        Octave octave = Octave.ONE_LINE_OCTAVE;

        assertTrue(Arrays.equals(noteNames, octave.getNoteNames()));
    }

    public void testNext() {
        Octave octave = Octave.ONE_LINE_OCTAVE;
        Octave nextOctave = Octave.TWO_LINE_OCTAVE;

        assertEquals(nextOctave, octave.next());
    }

    public void testNextNoChange() {
        Octave lastOctave = Octave.FOUR_LINE_OCTAVE;

        assertEquals(lastOctave, lastOctave.next());
    }

    public void testPrevious() {
        Octave octave = Octave.THREE_LINE_OCTAVE;
        Octave previousOctave = Octave.TWO_LINE_OCTAVE;

        assertEquals(previousOctave, octave.previous());
    }

    public void testPreviousNoChange() {
        Octave firstOctave = Octave.CONTRA_OCTAVE;

        assertEquals(firstOctave, firstOctave.previous());
    }
}
