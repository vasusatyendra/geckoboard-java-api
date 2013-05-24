package org.paules.geckoboard;

import java.io.IOException;

import org.paules.geckoboard.api.Connector;
import org.paules.geckoboard.api.widget.FunnelGraph;


public class Main
{

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
        FunnelGraph push = new FunnelGraph("31262-904a4378-e053-4e2b-b66e-d514e4987d90", "reverse", false);
        push.addData("one", 190);
        push.addData("two", 180);
        push.addData("three", 150);
        push.addData("four", 120);
        push.addData("five", 10);
        Connector connector = new Connector("dfe9860d82ce338f43ecb8a03876e8ef");
        connector.push(push);
    }

}
