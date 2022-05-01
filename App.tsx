import React from 'react'
import { Button, StyleSheet, Text, View } from 'react-native'
import { NativeModules } from 'react-native';

const { CalendarModule } = NativeModules;

const App = () => {
  console.log(CalendarModule);
  CalendarModule.createCalendarEvent((res: any) => console.log(res));

  const createCalendarEventPromise = async () => {
    try {
      var result = await CalendarModule.createCalendarPromise();
      console.log(result);
    } catch (e) {
      console.log(e);
    }
  }
  
  return (
    <View style={styles.container}>
      <Text>Native Modules React Native</Text>
      <Button 
        title="Calendar Event Promise"
        onPress={createCalendarEventPromise}
      />
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