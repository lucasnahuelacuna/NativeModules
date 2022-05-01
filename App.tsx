import React from 'react'
import { StyleSheet, Text, View } from 'react-native'
import { NativeModules } from 'react-native';

const { CalendarModule } = NativeModules;

const App = () => {
  console.log(CalendarModule);
  CalendarModule.createCalendarEvent((res: any) => console.log(res));

  return (
    <View style={styles.container}>
      <Text>Native Modules React Native</Text>
    </View>
  )
}

export default App

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  }
});