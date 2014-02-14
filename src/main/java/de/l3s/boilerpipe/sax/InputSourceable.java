/**
 * Copyright (C) 2013 Christian Kohlschütter (ckkohl79@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.l3s.boilerpipe.sax;

import org.xml.sax.InputSource;

/**
 * An InputSourceable can return an arbitrary number of new {@link InputSource}s for a given document.
 * 
 * @author Christian Kohlschütter
 */
public interface InputSourceable {
	InputSource toInputSource();
}
