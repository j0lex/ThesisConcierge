// Generated by view binder compiler. Do not edit!
package com.example.thesisconcierge.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.thesisconcierge.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonFloor1;

  @NonNull
  public final Button buttonFloor2;

  @NonNull
  public final Button buttonFloor3;

  @NonNull
  public final Button buttonFloor4;

  @NonNull
  public final Button buttonFloor5;

  @NonNull
  public final Button buttonFloor6;

  @NonNull
  public final GridLayout roomButtonsContainer;

  @NonNull
  public final TextView textSelectFloorAndRoom;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttonFloor1,
      @NonNull Button buttonFloor2, @NonNull Button buttonFloor3, @NonNull Button buttonFloor4,
      @NonNull Button buttonFloor5, @NonNull Button buttonFloor6,
      @NonNull GridLayout roomButtonsContainer, @NonNull TextView textSelectFloorAndRoom) {
    this.rootView = rootView;
    this.buttonFloor1 = buttonFloor1;
    this.buttonFloor2 = buttonFloor2;
    this.buttonFloor3 = buttonFloor3;
    this.buttonFloor4 = buttonFloor4;
    this.buttonFloor5 = buttonFloor5;
    this.buttonFloor6 = buttonFloor6;
    this.roomButtonsContainer = roomButtonsContainer;
    this.textSelectFloorAndRoom = textSelectFloorAndRoom;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_floor_1;
      Button buttonFloor1 = ViewBindings.findChildViewById(rootView, id);
      if (buttonFloor1 == null) {
        break missingId;
      }

      id = R.id.button_floor_2;
      Button buttonFloor2 = ViewBindings.findChildViewById(rootView, id);
      if (buttonFloor2 == null) {
        break missingId;
      }

      id = R.id.button_floor_3;
      Button buttonFloor3 = ViewBindings.findChildViewById(rootView, id);
      if (buttonFloor3 == null) {
        break missingId;
      }

      id = R.id.button_floor_4;
      Button buttonFloor4 = ViewBindings.findChildViewById(rootView, id);
      if (buttonFloor4 == null) {
        break missingId;
      }

      id = R.id.button_floor_5;
      Button buttonFloor5 = ViewBindings.findChildViewById(rootView, id);
      if (buttonFloor5 == null) {
        break missingId;
      }

      id = R.id.button_floor_6;
      Button buttonFloor6 = ViewBindings.findChildViewById(rootView, id);
      if (buttonFloor6 == null) {
        break missingId;
      }

      id = R.id.room_buttons_container;
      GridLayout roomButtonsContainer = ViewBindings.findChildViewById(rootView, id);
      if (roomButtonsContainer == null) {
        break missingId;
      }

      id = R.id.text_select_floor_and_room;
      TextView textSelectFloorAndRoom = ViewBindings.findChildViewById(rootView, id);
      if (textSelectFloorAndRoom == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, buttonFloor1, buttonFloor2,
          buttonFloor3, buttonFloor4, buttonFloor5, buttonFloor6, roomButtonsContainer,
          textSelectFloorAndRoom);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
