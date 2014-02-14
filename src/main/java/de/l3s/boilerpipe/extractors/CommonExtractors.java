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
package de.l3s.boilerpipe.extractors;

import de.l3s.boilerpipe.BoilerpipeExtractor;

/**
 * Provides quick access to common {@link BoilerpipeExtractor}s.
 * 
 * @author Christian Kohlschütter
 */
public final class CommonExtractors {
	private CommonExtractors() {
	}

	/**
	 * Works very well for most types of Article-like HTML.
	 */
	public static final ArticleExtractor ARTICLE_EXTRACTOR = ArticleExtractor.INSTANCE;

	/**
	 * Usually worse than {@link ArticleExtractor}, but simpler/no heuristics.
	 */
	public static final DefaultExtractor DEFAULT_EXTRACTOR = DefaultExtractor.INSTANCE;

	/**
	 * Like {@link DefaultExtractor}, but keeps the largest text block only.
	 */
	public static final LargestContentExtractor LARGEST_CONTENT_EXTRACTOR = LargestContentExtractor.INSTANCE;
	
	
	/**
	 * Trained on krdwrd Canola (different definition of "boilerplate"). You may
	 * give it a try.
	 */
	public static final CanolaExtractor CANOLA_EXTRACTOR = CanolaExtractor.INSTANCE;

	/**
	 * Dummy Extractor; should return the input text. Use this to double-check
	 * that your problem is within a particular {@link BoilerpipeExtractor}, or
	 * somewhere else.
	 */
	public static final KeepEverythingExtractor KEEP_EVERYTHING_EXTRACTOR = KeepEverythingExtractor.INSTANCE;
}
