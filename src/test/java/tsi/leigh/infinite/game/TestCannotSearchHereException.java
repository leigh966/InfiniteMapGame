package tsi.leigh.infinite.game;

import org.junit.jupiter.api.Test;

class TestCannotSearchHereException
{
    @Test
    void TestCannnotSearchHereException()
    {
        CannotSearchHereException cnsh = new CannotSearchHereException("bleh");
    }
}
