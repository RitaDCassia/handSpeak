package co.rita.handspeak

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// precisamos de tes componentes
// então temos que escrever que é um fragmento extendido
class ViewPagerAdapter(list: ArrayList<Fragment>, fm: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fm, lifecycle) {

    // lista
    private val fragmentList = list

    override fun getItemCount(): Int {
        // tamnaho da lista de fragmentos
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        // ler uma lista de fragmentos
        return fragmentList[position]
    }


}