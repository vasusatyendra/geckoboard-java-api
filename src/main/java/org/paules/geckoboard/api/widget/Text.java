package org.paules.geckoboard.api.widget;

import java.util.LinkedList;
import java.util.List;

import org.paules.geckoboard.api.Push;
import org.paules.geckoboard.api.error.ValidationException;
import org.paules.geckoboard.api.json.common.TextItem;
import org.paules.geckoboard.api.json.common.TextItemType;

import com.google.gson.annotations.SerializedName;

public class Text extends Push {
    @SerializedName( "item" )
    private List<TextItem> text = new LinkedList<TextItem>();

    public Text( String widgetKey ) {
        super( widgetKey );
    }

    public void addText( String text ) {
        addText( text, TextItemType.NONE );
    }

    public void addText( String text, TextItemType type ) {
        this.text.add( new TextItem( text, type ) );
    }

    @Override
    protected void validate() throws ValidationException {
        if ( text.size() == 0 ) {
            throw new ValidationException( "item", "Cannot be empty" );
        }
    }
}
