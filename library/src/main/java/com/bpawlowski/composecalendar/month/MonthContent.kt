package com.bpawlowski.composecalendar.month

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bpawlowski.composecalendar.day.DayState
import com.bpawlowski.composecalendar.selection.SelectionState
import com.bpawlowski.composecalendar.week.WeekContent
import com.bpawlowski.composecalendar.week.getWeeks

@Composable
internal fun MonthContent(
  showAdjacentMonths: Boolean,
  selectionState: SelectionState,
  month: Month,
  modifier: Modifier = Modifier,
  dayContent: @Composable BoxScope.(DayState) -> Unit,
  weekHeader: @Composable RowScope.() -> Unit,
  monthContainer: @Composable (content: @Composable () -> Unit) -> Unit,
) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .wrapContentHeight(),
    content = weekHeader,
  )
  monthContainer {
    Column {
      month.yearMonth.getWeeks(showAdjacentMonths).forEach { week ->
        WeekContent(
          week = week,
          selectionState = selectionState,
          dayContent = dayContent,
        )
      }
    }
  }
}