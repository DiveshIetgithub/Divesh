import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.applicationform.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get references to views
        val fnameEditText: EditText = binding.FirstName
        val lnameEditText: EditText = binding.LastName
        val mobileEditText: EditText = binding.mobile
        val alterEditText:EditText = binding.alternative
        val emailEditText: EditText = binding.email
        val genderRadioGroup: RadioGroup = binding.radio
        val maleRadioButton: RadioButton = binding.radioButtonMale
        val femaleRadioButton: RadioButton = binding.radioButtonFemale
        val tsgenderRadioButton: RadioButton = binding.radioButtonTsGender
        val agreementCheckBox: CheckBox = binding.agreementCheckbox
        val submitButton: Button = binding.btnSubmit

        // set onClickListener for submit button
        submitButton.setOnClickListener {
            // get input values
            val fname = fnameEditText.text.toString()
            val lname = lnameEditText.text.toString()
            val mobile = mobileEditText.text.toString()
            val email = emailEditText.text.toString()
            val gender = if (maleRadioButton.isChecked) "Male" else if (femaleRadioButton.isChecked) "Female" else "TsGender"
            val agreement = agreementCheckBox.isChecked

            // validate input
            if (fname.isEmpty() || lname.isEmpty() || mobile.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "First name: $fname\nLast name: $lname", Toast.LENGTH_SHORT).show()

            } else if (!isValidEmail(email)) {
               Toast.makeText(this,"Email : $email",Toast.LENGTH_SHORT).show()
            } else if (!isValidMobile(mobile)) {
                Toast.makeText(this, "mobile : $mobile", Toast.LENGTH_SHORT).show()
            } else if (!agreement) {
                Toast.makeText(this, "agreement : $agreement", Toast.LENGTH_SHORT).show()
            } else {
                // display success message
                val message = "Thank you for submitting your application, $fname $lname! We will contact you at $mobile or $email regarding your application."
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidMobile(mobile: String): Boolean {
        return android.util.Patterns.PHONE.matcher(mobile).matches()
    }
}





