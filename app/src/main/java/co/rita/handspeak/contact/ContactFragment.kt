package co.rita.handspeak.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import co.rita.handspeak.R

class ContactFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var messageEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        nameEditText = view.findViewById(R.id.nameEditText)
        emailEditText = view.findViewById(R.id.emailEditText)
        messageEditText = view.findViewById(R.id.messageEditText)
        submitButton = view.findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val message = messageEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && message.isNotEmpty()) {
                sendEmail(name, email, message)
            } else {
                Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        // botoes insta e zap

        val whatsappImageView = view.findViewById<ImageView>(R.id.whatsappImageView)
        whatsappImageView.setOnClickListener {
            openWhatsApp()
        }

        val instagramImageView = view.findViewById<ImageView>(R.id.instagramImageView)
        instagramImageView.setOnClickListener {
            openInstagram()
        }

        return view

    }

    // função email
    private fun sendEmail(name: String, email: String, message: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("rita16t@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Novo formulário HankSpeak")
            putExtra(Intent.EXTRA_TEXT, "Nome: $name\nE-mail: $email\nMensagem: $message")
        }

        val chooser = Intent.createChooser(intent, "Enviar e-mail")
        if (chooser.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(chooser)
        } else {
            Toast.makeText(requireContext(), "Nenhum aplicativo de e-mail instalado", Toast.LENGTH_SHORT).show()
        }
    }

    // funcoes wpp e insta

    private fun openWhatsApp() {
        val phoneNumber = "55091992819300" // Substitua pelo número de telefone ou ID do WhatsApp desejado
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://wa.me/$phoneNumber")
        }
        startActivity(intent)
    }

    private fun openInstagram() {
        val username = "_ritaaaaaaaaaa" // Substitua pelo nome de usuário do Instagram desejado
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://www.instagram.com/$username")
        }
        startActivity(intent)
    }


}