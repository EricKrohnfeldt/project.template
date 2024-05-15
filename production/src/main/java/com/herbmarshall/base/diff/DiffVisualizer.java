/*
 * This file is part of herbmarshall.com: base.library  ( hereinafter "base.library" ).
 *
 * base.library is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either version 2 of the License,
 * or (at your option) any later version.
 *
 * base.library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with base.library.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package com.herbmarshall.base.diff;

import java.util.Objects;

/** Module to generate a diff visualization of two objects. */
public final class DiffVisualizer {

	static final String DEFAULT_MESSAGE = "No diff generated, please set DiffGenerator";
	private static DiffGenerator generator;

	static {
		setGenerator( null );
	}

	private DiffVisualizer() {}

	/**
	 * Create a text representation of an object diff.
	 * @param expected The value to compare with
	 * @param actual The value to compare to
	 */
	public static String generate( Object expected, Object actual ) {
		return generator.diff( expected, actual );
	}

	/**
	 * Set the {@link DiffGenerator} to use for display.
	 * @param generator The {@link DiffGenerator} to use.  {@code null} value will set to default
	 */
	public static void setGenerator( DiffGenerator generator ) {
		DiffVisualizer.generator = Objects.requireNonNullElse(
			generator,
			( expected, actual ) -> DEFAULT_MESSAGE
		);
	}

}
