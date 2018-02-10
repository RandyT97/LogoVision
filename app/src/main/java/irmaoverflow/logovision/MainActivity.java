package irmaoverflow.logovision;

//import android.support.v7.app.AppCompatActivity;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.hardware.camera2.*;


public class MainActivity extends Activity implements View.OnClickListener {


    private Button cap_but;
    private ImageView imageView;
    private Uri file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cap_but = (Button) findViewById(R.id.cap_but);
        imageView = (ImageView) findViewById(R.id.imageView);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            cap_but.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }


    }

    /** Called when the user touches the button */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        if(requestCode == 0)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                cap_but.setEnabled(true);
            }
        }

    }

    public void Capture_Photo(View view)
    {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       // file = Uri.fromFile(getOutputMediaFile());
      //  intent.putExtra(MediaStore.EXTRA_OUTPUT,file);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if(requestCode == 100)
        {
            if (resultCode == RESULT_OK)
            imageView.setImageURI(file);
        }
    }

    private static File getOutputMediaFile()
    {
        File foto_store_path = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"Photo Snapped!");

        if(!foto_store_path.exists())
        {
            if(!foto_store_path.mkdirs())
            {
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(foto_store_path.getPath()+ File.separator + "IMG_" + timeStamp + ".jpg");
    }

    @Override
    public void onClick(View view) {

    }
}
