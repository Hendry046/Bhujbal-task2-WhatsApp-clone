package com.example.hendry_whatsapp;

import androidx.annotation.Nullable;  // Use androidx instead of android.support.v4
import androidx.fragment.app.Fragment;  // Use androidx instead of android.support.v4
import androidx.fragment.app.FragmentManager;  // Use androidx instead of android.support.v4
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAccessorAdapter extends FragmentPagerAdapter {
    public TabsAccessorAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;

            case 1:
                UpdatesFragment updatesFragment = new UpdatesFragment();
                return updatesFragment;

            case 2:
                CallsFragment callsFragment = new CallsFragment();
                return callsFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Chats";

            case 1:
                return "Updates";

            case 2:
                return "Calls";

            default:
                return null;
        }
    }
}
