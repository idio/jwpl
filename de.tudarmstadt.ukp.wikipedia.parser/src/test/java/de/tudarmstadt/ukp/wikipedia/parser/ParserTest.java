package de.tudarmstadt.ukp.wikipedia.parser;

import de.tudarmstadt.ukp.wikipedia.api.WikiConstants;
import de.tudarmstadt.ukp.wikipedia.parser.mediawiki.MediaWikiParser;
import de.tudarmstadt.ukp.wikipedia.parser.mediawiki.MediaWikiParserFactory;
import org.junit.Test;

/**
 * Created by dav009 on 23/06/2015.
 */
public class ParserTest {

    @Test
    public void testGalleryLinks(){
        String title = "Wikipedia API";

        String LF = "\n";
        String text = "India collided with Asia {{Ma|55|45}} creating the Himalayas; Arabia collided with Eurasia, " +
                "closing the [[Tethys ocean]] and creating the Zagros Mountains, " +
                "around {{Ma|35}}.<ref name=Allen2008>{{cite doi|10.1016/j.palaeo.2008.04.021 }}</ref>\n" +
                "<gallery>\n" +
                "|35  million years ago\n" +
                "|20  million years ago\n" +
                "</gallery>";

        MediaWikiParserFactory pf = new MediaWikiParserFactory(WikiConstants.Language.english);
        MediaWikiParser parser = pf.createParser();

        ParsedPage pp = parser.parse(text);

        for (Section s : pp.getSections()){
            for (Link link : s.getLinks()) {
                assert(!link.getTarget().equals(""));
            }
        }


    }
}
