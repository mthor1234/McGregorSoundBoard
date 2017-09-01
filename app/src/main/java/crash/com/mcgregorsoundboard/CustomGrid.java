package crash.com.mcgregorsoundboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/*
Customgrid uses the singlegrid.xml layout to populate the activty_main.xml layout. BaseAdapter is needed
 */

public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private final int Imageid;
    private ImageView imageView;


    public CustomGrid(Context c, int Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 9;

    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }


//    public ImageView getImageView() {
//        return imageView;
//    }


    // getView() does the majority of the work in the CustomGrid Class
    // Overrides the baseadapter method to inflate the activity_main layout by
    // taking grid_single.xml and assigning all of the variables / elements

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            imageView = (ImageView)grid.findViewById(R.id.grid_image);


            imageView.setBackgroundResource(Imageid);


        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
