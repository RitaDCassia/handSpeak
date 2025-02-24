package co.rita.handspeak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import co.rita.handspeak.screens.FristScreen
import co.rita.handspeak.screens.SecondScreen
import co.rita.handspeak.screens.ThitdScreen
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class OnBoardingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding, container, false)

        // lista de fregmentos
        val fragmentList = arrayListOf<Fragment>(
            // adicionar as telas
            FristScreen(),
            SecondScreen(),
            ThitdScreen()
        )

        // escrevendo o adapter
        val adapter = ViewPagerAdapter(
            // passando a lista de fragmentos
            fragmentList,
            // gerenciador de fragmentos atividade e estilo de vida
            requireActivity().supportFragmentManager,
            lifecycle
        )

        // paginas a direita
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)

        viewPager.adapter = adapter

        // conexao da biblioteca
        val indicator = view.findViewById<DotsIndicator>(R.id.dots_indicator)
        indicator.attachTo(viewPager)

        return view
    }


}