package cl.awakelab.ejercicioindividual14modulo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.awakelab.ejercicioindividual14modulo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk.setOnClickListener {
            when(binding.radioGroup.checkedRadioButtonId) {
                R.id.radioButtonVerSaldo -> {
                    binding.editTextSaldo.setText(saldo.toString())
                }
                R.id.radioButtonIngresar -> ingresarSaldo()
                R.id.radioButtonRetirar -> retirarSaldo()
                R.id.radioButtonSalir -> finish()
            }
        }
    }

    private fun retirarSaldo() {
        val monto = binding.editTextIngreso.text.toString().toInt()
        if(monto > saldo) {
            crearMensaje("Cantidad ingresada es mayor a saldo.")
        } else {
            saldo -= monto
            limpiarIngreso()
            crearMensaje("Dinero extraido exitosamente. Su nuevo saldo es: $saldo")
        }

    }

    fun ingresarSaldo() {
        saldo += binding.editTextIngreso.text.toString().toInt()
        limpiarIngreso()
        crearMensaje("Su saldo ha sido actualizado: $saldo")
    }

    fun limpiarIngreso() {
        binding.editTextIngreso.text.clear()
    }

    fun crearMensaje(s: String) {
        Toast.makeText(baseContext, s, Toast.LENGTH_SHORT).show()
    }

}