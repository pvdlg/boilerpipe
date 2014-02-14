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
package de.l3s.boilerpipe.filters.simple;

import java.util.Iterator;
import java.util.List;

import de.l3s.boilerpipe.BoilerpipeFilter;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.conditions.TextBlockCondition;
import de.l3s.boilerpipe.document.TextBlock;
import de.l3s.boilerpipe.document.TextDocument;

public class SurroundingToContentFilter implements BoilerpipeFilter {
	public static final SurroundingToContentFilter INSTANCE_TEXT = new SurroundingToContentFilter(new TextBlockCondition() {
		
		public boolean meetsCondition(TextBlock tb) {
			return tb.getLinkDensity() == 0 && tb.getNumWords() > 6;
		}
	});

	private final TextBlockCondition cond;
    public SurroundingToContentFilter(final TextBlockCondition cond) {
		this.cond = cond;
    }
    
    public boolean process(TextDocument doc)
            throws BoilerpipeProcessingException {

        List<TextBlock> tbs = doc.getTextBlocks();
        if (tbs.size() < 3) {
            return false;
        }
        
        TextBlock a = tbs.get(0);
        TextBlock b = tbs.get(1);
        TextBlock c;
        boolean hasChanges = false;
        for (Iterator<TextBlock> it= tbs.listIterator(2);it.hasNext();) {
            c = it.next();
            if(!b.isContent() && a.isContent() && c.isContent() && cond.meetsCondition(b)) {
            	b.setIsContent(true);
            	hasChanges = true;
            }
            
            a = c;
            if(!it.hasNext()) {
            	break;
            }
            b = it.next();
        }

        return hasChanges;
    }

}
